package World;

import GameUI.GameVisual;
import Main.Globals;
import Main.Main;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author d.holmberg
 */
public class Map {

    public static boolean initalized = false;
    
    private static final int MAP_WIDTH = 128;
    private static final int MAP_HEIGHT = 72;
    
    private static int displayWidth;
    private static int displayHeight;
    
    private static Tile[][] tileGrid;
    private static Border[][] borderGrid;
    private static int[][] tileType; 
    private static int[][] borderType;
    
    private static int rightOff = 0;
    private static int downOff = 0;
    
    
    public static void initalize(){
        if (!Globals.initalized) Globals.initalize();
        
        displayWidth = (Globals.settings.getWidth()/Tile.SIZE)+1;
        displayHeight = (Globals.settings.getHeight()/Tile.SIZE)+1;
        
        tileGrid  = new Tile[MAP_WIDTH][MAP_HEIGHT];
        borderGrid  = new Border[MAP_WIDTH][MAP_HEIGHT];
        tileType  = new int[MAP_WIDTH][MAP_HEIGHT];
        borderType  = new int[MAP_WIDTH][MAP_HEIGHT];
        
        initalized = true;
        
        //readFile();
        SeedTiles();
        GrowTiles();
        redrawMap();
        
    }
    
    private static void readFile(){
        if (!initalized) initalize();
        try {
            File temp = new File("src\\World\\Map.txt");//reads the map and stores it in tileType, also sets all borderType to 0
            Scanner s = new Scanner(temp);
            for (int i = 0; i < MAP_WIDTH; i++){
                for (int j = 0; j < MAP_HEIGHT; j++){
                    tileType[i][j] = s.nextInt();
                    borderType[i][j] = 0;
                }
            }
            s.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Map.txt not found - "+e.getMessage());
            Main.exit();
        }
        
        for (int x = rightOff; x < displayWidth; x++){
            for (int y = downOff; y <  displayWidth; y++){
                tileGrid[x][y] = new Tile(x, y);//creates all the tiles
                GameVisual.worldAdd(tileGrid[x][y]);//adds the tiles to the tile container
                                
                //borderGrid[i][j] = new Border(i, j);//creates all the borders
                //GameVisual.worldAdd(borderGrid[i][j]);//adds the borders to the tile container
                
            }
        }
        redrawMap();
    }

    
    private static void SeedTiles() {
        
        for (int i = 0; i < MAP_WIDTH-1; i++){
            for (int j = 0; j < MAP_HEIGHT-1; j++){
                tileType[i][j] = -1;
            }
        }   
        
        Random random = new Random();
        int amount = (int) ((MAP_HEIGHT*MAP_WIDTH)/10);
        for (int i = 0; i < amount; i++) {
            int x = random.nextInt(100);
            
            if(x <= 40) tileType[random.nextInt(MAP_WIDTH-1)][random.nextInt(MAP_HEIGHT-1)] = 0;
            else if(x <= 80) tileType[random.nextInt(MAP_WIDTH-1)][random.nextInt(MAP_HEIGHT-1)] = 2;
            else if(x <= 100) tileType[random.nextInt(MAP_WIDTH-1)][random.nextInt(MAP_HEIGHT-1)] = 1;
            
        }
        
    }

    private static void GrowTiles() {
        boolean gate = true;
        while (gate) {
            gate = false;
            for (int x = 0; x < MAP_WIDTH-1; x++) {
                for (int y = 0; y < MAP_HEIGHT-1; y++) {
                    if(tileType[x][y] == -1){
                        gate = true;
                        Random r = new Random();
                        int direction = r.nextInt(4);
                        if (direction == 0 && x != MAP_WIDTH-1) tileType[x][y] = tileType[x+1][y];
                        if (direction == 0 && x == MAP_WIDTH-1) tileType[x][y] = tileType[0][y];
                        if (direction == 1 && x != 0) tileType[x][y] = tileType[x-1][y];
                        if (direction == 1 && x == 0) tileType[x][y] = tileType[MAP_WIDTH-1][y];
                        if (direction == 2 && y != MAP_HEIGHT-1) tileType[x][y] = tileType[x][y+1];
                        if (direction == 3 && y != 0) tileType[x][y] = tileType[x][y-1];
                        if (y == 0 || y == MAP_WIDTH-1) tileType[x][y] = 2; 
                    }
                }
            }
        }
    }


    
    public static void redrawMap(){
        for (int x = 0; x < displayWidth; x++){
            for (int y = 0; y < displayHeight; y++){
                System.out.println("X:" + x);
                System.out.println("Y:" + y);
                tileGrid[x][y].setTile(tileType[x + rightOff][y + downOff]);
                //borderGrid[x][y].setBorder(borderType[x + rightOff][y + downOff]);

            }
        }
    }
    
//    public static void LoadUnits(){
//        for (int x = 0; x <= WIDTH; x++){
//            for (int y = 0; y <= HEIGHT; y++){
//                if (UnitType.FindUnit(x,y) > -1){
//                    int index = UnitType.FindUnit(x,y);                    
//                    Unit unit = Globals.units.get(index);
//                    if (unit.x == x && unit.y == y){
//                        unit.setLocation((x - rightOff)*50, (y - downOff)*50);
//                        unit.setUnit(Globals.unitGrid[x][y]);
//                    }
//                    
//                }
//            }
//        }
//    }
    
    //----Variables-----------


    
    //----Object-Methods-------

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
