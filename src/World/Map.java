package World;

import GameUI.GameVisual;
import Main.Globals;
import Main.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author d.holmberg
 */
public class Map {

    public static boolean initalized = false;
    
    private static final int WIDTH = 128;
    private static final int HEIGHT = 72; 
    
    private static Tile[][] tileGrid;
    private static Border[][] borderGrid;
    private static int[][] tileType; 
    private static int[][] borderType;
    
    private static int rightOff = 0;
    private static int downOff = 0;
    
    
    public static void initalize(){
        if (!Globals.initalized) Globals.initalize();
        tileGrid  = new Tile[WIDTH][HEIGHT];
        borderGrid  = new Border[WIDTH][HEIGHT];
        tileType  = new int[WIDTH][HEIGHT];
        borderType  = new int[WIDTH][HEIGHT];
        
        initalized = true;
        
        readFile();
        
    }
    
    private static void readFile(){
        if (!initalized) initalize();
        try {
            File temp = new File("src\\World\\Map.txt");//reads the map and stores it in tileType, also sets all borderType to 0
            Scanner s = new Scanner(temp);
            for (int i = 0; i <= WIDTH-1; i++){
                for (int j = 0; j <= HEIGHT-1; j++){
                    tileType[i][j] = s.nextInt();
                    borderType[i][j] = 0;
                }
            }
            s.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Map.txt not found - "+e.getMessage());
            Main.exit();
        }
        
        for (int i = rightOff; i < WIDTH-1; i++){
            for (int j = downOff; j <  HEIGHT-1; j++){
                tileGrid[i][j] = new Tile(i, j);//creates all the tiles
                GameVisual.worldAdd(tileGrid[i][j]);//adds the tiles to the tile container
                                
                //borderGrid[i][j] = new Border(i, j);//creates all the borders
                //GameVisual.worldAdd(borderGrid[i][j]);//adds the borders to the tile container
                
            }
        }
        redrawMap();
    }

    public static void redrawMap(){
        for (int x = 0; x < WIDTH+1; x++){
            for (int y = 0; y < HEIGHT+1; y++){
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
