package World;

import Main.Globals;


/**
 *
 * @author d.holmberg
 */
public class Map {

    public static boolean initalized = false;
    
    private static int width; 
    private static int height; 
    
    private static Tile[][] tileGrid;
    private static Border[][] borderGrid;
    private static int[][] tileType; 
    private static int[][] borderType;
    
    public static void initalize(){
        
        width = (Globals.settings.width/Tile.SIZE) + 1;
        height = (Globals.settings.hight/Tile.SIZE) + 1;
        
        tileGrid  = new Tile[width][height];
        borderGrid  = new Border[width][height];
        tileType  = new int[width][height];
        borderType  = new int[width][height];
        
        initalized = true;
    }
    
    


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
