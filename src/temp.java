

import Main.Main;
import World.Border;
import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JLabel;

/**
 * used for the tile grid and some related mechanics
 *
 * @author Davin
 */
class Map {
    
    private static int x,y;//the width and height of the display, in tiles
    
    private static Tile[][] grid;//the storage for the tile grid
    static Border[][] borderGrid;//the storage for the border grid
    private static int[][] borderType;//the types for the border grid
    private static int[][] tileType;//the types for the tile grid
    
    private final int WIDTH = 128;//the grid width and height
    private final int HEIGHT = 72;
    
    
    
    
    Map(){
        

        x = Visual.width/50;//makes the displays width and height
        y = Visual.hight/50;
        
        tileType  = new int[WIDTH][HEIGHT];//intializes all the grids
        grid  = new Tile[WIDTH][HEIGHT];
        borderGrid  = new Border[WIDTH][HEIGHT];
        borderType  = new int[WIDTH][HEIGHT];
        
        try {
            File temp = new File("src\\finalProject\\Map.txt");//reads the map and stores it in tileType, also sets all borderType to 0
            Scanner s = new Scanner(temp);
            for (int j = 0; j <= HEIGHT-1; j++){
                for (int i = 0; i <= WIDTH-1; i++){
                    borderType[i][j] = 0;
                    tileType[i][j] = s.nextInt();
                }
            }
            s.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Map.txt not found - "+e.getMessage());
            Main.exit();
        }
        
        for (int i = Visual.getRightOff(); i < WIDTH-1; i++){
            for (int j = Visual.getDownOff(); j < HEIGHT-1; j++){
                grid[i][j] = new Tile(i, j);//creates all the tiles
                grid[i][j].setTile(tileType[i][j]);//sets the type of all tiles
                Visual.setTiles((Container) Visual.getTiles().add(grid[i][j]));//adds the tiles to the tile container
                
                borderGrid[i][j] = new Border(i, j);//creates all the borders
                borderGrid[i][j].setBorder(borderType[i][j]);//sets the type of all borders
                Visual.setTiles((Container) Visual.getTiles().add(borderGrid[i][j],0));//adds the borders to the tile container
                
            }
        }
    }   
}

/*
public static void redrawMap(){
        for (int i = 0; i < Map.x; i++){
                for (int j = 0; j < Map.y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + rightOff][j + downOff]);
                    Map.borderGrid[i][j].setBorder(Map.borderType[i + rightOff][j + downOff]);

                }
            }
    }
    
    public static void LoadUnits(){
        for (int i = 0; i <= 127; i++){
            for (int j = 0; j <= 71; j++){
                if (UnitType.FindUnit(i,j) > -1){
                    int index = UnitType.FindUnit(i,j);
                    Unit unit = FinalProject.units.get(index);
                    if (unit.x == i&& unit.y == j){
                        unit.setLocation((i- rightOff)*50, (j- downOff)*50);
                        unit.setUnit(Globals.unitGrid[i][j]);
                    }
                }
            }
        }
    }
*/