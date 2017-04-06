package World;

import GameVisual.Tile;
import GameVisual.GameVisual;
import Utill.Globals;
import java.awt.Point;
import java.util.Random;


/**
 *
 * @author d.holmberg
 */
public abstract class Map {

    public static boolean initalized = false;
    
    public static final int MAP_WIDTH = 200;
    public static final int MAP_HEIGHT = 100;
    
    protected static int displayWidth;
    protected static int displayHeight;
    
    protected static Tile[][] tileDisplay;
    protected static final int[][] TILE_WORLD = new int[MAP_WIDTH][MAP_HEIGHT];
    
    protected static int rightOff = 0;
    protected static int downOff = 0;
    
    
    public static void initalize(){
        if (!Globals.initalized) Globals.initalize();
        
        displayWidth = (Globals.settings.getWidth()/Tile.SIZE)+1;
        displayHeight = (Globals.settings.getHeight()/Tile.SIZE);
        
        tileDisplay = new Tile[displayWidth][displayHeight];
        
        initalized = true;
        
        SeedTiles();
        GrowTiles();
        redrawMap();
        redrawUnits();
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
        
        for (int x = 0; x < displayWidth; x++){
            for (int y = 0; y < displayHeight; y++){
                
                int xAdj = x;
                if(x+rightOff >= MAP_WIDTH) xAdj -= MAP_WIDTH;
                
                int yAdj = y;
                if(y+downOff >= MAP_HEIGHT) yAdj -= MAP_HEIGHT;
                
                tileDisplay[x][y].setTile(TILE_WORLD[xAdj + rightOff][yAdj + downOff]);
            }
        }
    }
    
    public static void redrawUnits(){
        if(rightOff == -1) rightOff = MAP_WIDTH-1;
        if(rightOff == MAP_WIDTH) rightOff = 0;
        
        for (int i = 0; i < Globals.unitList.size(); i++) {
            Point p = Globals.unitList.get(i).getPos();
            Globals.unitList.get(i).getDisplay().setLocation((p.x-rightOff)*50, (p.y-downOff)*50);
            
        }
    }
    
    public static int range(Point p1, Point p2){
        int deltaX = p2.x - p1.x;
        int deltaY = p2.y - p2.x;
        return Math.abs(deltaX) +  Math.abs(deltaY);
    }
    
    //----Variables-----------

    public static int getDisplayHeight() {
        return displayHeight;
    }
    public static int getDisplayWidth() {
        return displayWidth;
    }

    public static void setTile(int x, int y, int type){
        TILE_WORLD[x][y] = type;
        redrawMap();
    }

    public static void setRightOff(int rightOff) {
        Map.rightOff = rightOff;
    }

    public static int getDownOff() {
        return downOff;
    }

    public static int getRightOff() {
        return rightOff;
    }
    
    public static void changeDownOff(int i) {
        downOff += i;
    }

    public static void changeRightOff(int i) {
        rightOff += i;
    }

    
}
