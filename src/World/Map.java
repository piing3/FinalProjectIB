package World;

import GameLogic.Player;
import GameUI.GameVisual;
import Main.Globals;
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
    
    private static int displayWidth;
    private static int displayHeight;
    
    private static Tile[][] tileDisplay;
    private static final int[][] TILE_WORLD = new int[MAP_WIDTH][MAP_HEIGHT];
    
    public static int rightOff = 0;
    public static int downOff = 0;
    
    
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
    
    public static boolean checkTileLand(int startX, int startY) {
        if (TILE_WORLD[startX][startY] == 0) return true;
        if (TILE_WORLD[startX][startY] == 1) return true;
        return false;
    }

    public static void setFocus(Player player) {
        if(!initalized) initalize();
        rightOff = player.getStartX()-(displayWidth/2);
        downOff = player.getStartY()-(displayHeight/2);
        
        if(rightOff < 0) rightOff = MAP_WIDTH + rightOff;
        if(downOff < 0) downOff = MAP_HEIGHT + downOff;
        
        redrawMap();
        redrawUnits();
    }
}
