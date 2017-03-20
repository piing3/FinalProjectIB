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
    
    public static final int MAP_WIDTH = 200;
    public static final int MAP_HEIGHT = 100;
    
    private static int displayWidth;
    private static int displayHeight;
    
    private static Tile[][] tileDisplay;
    private static Border[][] borderDisplay;
    private static final int[][] TILE_WORLD = new int[MAP_WIDTH][MAP_HEIGHT]; 
    private static final int[][] BORDER_TYPE = new int[MAP_WIDTH][MAP_HEIGHT];
    
    public static int rightOff = 0;
    public static int downOff = 0;
    
    
    public static void initalize(){
        if (!Globals.initalized) Globals.initalize();
        
        displayWidth = (Globals.settings.getWidth()/Tile.SIZE)+1;
        displayHeight = (Globals.settings.getHeight()/Tile.SIZE);
        
        tileDisplay = new Tile[displayWidth][MAP_HEIGHT];
        borderDisplay = new Border[displayWidth][MAP_HEIGHT];
        
        initalized = true;
        
        //readFile();
        SeedTiles();
        GrowTiles();
        redrawMap();
        
    }
    
    private static void SeedTiles() {
        
        for (int x = 0; x < MAP_WIDTH; x++){
            for (int y = 0; y < MAP_HEIGHT; y++){
                TILE_WORLD[x][y] = -1;
                if (x < displayWidth && y < displayHeight) {
                    tileDisplay[x][y] = new Tile(x, y);//creates all the tiles
                    GameVisual.worldAdd(tileDisplay[x][y]);//adds the tiles to the tile container
                }
                
            }
        }   
        
        Random random = new Random();
        int amount = (int) ((MAP_HEIGHT*MAP_WIDTH)/10);
        for (int i = 0; i < amount; i++) {
            int seed = random.nextInt(100);
            
            if(seed <= 65) TILE_WORLD[random.nextInt(MAP_WIDTH-1)][random.nextInt(MAP_HEIGHT-1)] = 0;
            else if(seed <= 80) TILE_WORLD[random.nextInt(MAP_WIDTH-1)][random.nextInt(MAP_HEIGHT-1)] = 1;
            else if(seed <= 100) TILE_WORLD[random.nextInt(MAP_WIDTH-1)][random.nextInt(MAP_HEIGHT-1)] = 2;
            
        }
        
    }

    private static void GrowTiles() {
        boolean gate = true;
        while (gate) {
            gate = false;
            for (int x = 0; x < MAP_WIDTH; x++) {
                for (int y = 0; y < MAP_HEIGHT; y++) {
                    if(TILE_WORLD[x][y] == -1){
                        gate = true;
                        Random r = new Random();
                        int direction = r.nextInt(4);
                        
                        if (direction == 0 && x != MAP_WIDTH-1) TILE_WORLD[x][y] = TILE_WORLD[x+1][y];
                        if (direction == 0 && x == MAP_WIDTH-1) TILE_WORLD[x][y] = TILE_WORLD[0][y];
                        if (direction == 1 && x != 0) TILE_WORLD[x][y] = TILE_WORLD[x-1][y];
                        if (direction == 1 && x == 0) TILE_WORLD[x][y] = TILE_WORLD[MAP_WIDTH-1][y];
                        if (direction == 2 && y != MAP_HEIGHT-1) TILE_WORLD[x][y] = TILE_WORLD[x][y+1];
                        if (direction == 3 && y != 0) TILE_WORLD[x][y] = TILE_WORLD[x][y-1];
                        if (y <= 4 || y >= (MAP_HEIGHT)-4) TILE_WORLD[x][y] = 2; 
                    }
                }
            }
        }
    }
    
    public static void redrawMap(){
        if(rightOff >= MAP_WIDTH) rightOff -= MAP_WIDTH;
        if(rightOff < 0) rightOff += MAP_WIDTH;
        for (int x = 0; x < displayWidth; x++){
            for (int y = 0; y < displayHeight; y++){
                int xAdj = x;
                if(x+rightOff >= MAP_WIDTH) xAdj -= MAP_WIDTH;
                if(x+rightOff < 0) xAdj += MAP_WIDTH;
                if (y+downOff == 72){
                    System.out.println("error");
                };
                tileDisplay[x][y].setTile(TILE_WORLD[xAdj + rightOff][y + downOff]);
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

    public static int getDisplayHeight() {
        return displayHeight;
    }
    public static int getDisplayWidth() {
        return displayWidth;
    }


    
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
