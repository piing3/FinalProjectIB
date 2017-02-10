package finalProject;

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
    
    static int x,y;//the width and height of the display, in tiles
    
    static Tile[][] grid;//the storage for the tile grid
    static Border[][] borderGrid;//the storage for the border grid
    static int[][] borderType;//the types for the border grid
    static int[][] tileType;//the types for the tile grid
    
    final int WIDTH = 128;//the grid width and height
    final int HEIGHT = 72;
    
    Map() throws FileNotFoundException{
        

        x = Visual.width/50;//makes the displays width and height
        y = Visual.hight/50;
        
        tileType  = new int[WIDTH][HEIGHT];//intializes all the grids
        grid  = new Tile[WIDTH][HEIGHT];
        borderGrid  = new Border[WIDTH][HEIGHT];
        borderType  = new int[WIDTH][HEIGHT];
                
//        File temp = new File("src\\finalProject\\Map.txt");//reads the map and stores it in tileType, also sets all borderType to 0
//        Scanner s = new Scanner(temp);
//        for (int j = 0; j <= HEIGHT-1; j++){
//            for (int i = 0; i <= WIDTH-1; i++){
//                borderType[i][j] = 0;
//                tileType[i][j] = s.nextInt();
//            }
//        }
//        s.close(); 
        
        for (int i = Visual.rightOff; i < WIDTH-1; i++){
            for (int j = Visual.downOff; j < HEIGHT-1; j++){
                grid[i][j] = new Tile(i, j);//creates all the tiles
                grid[i][j].setTile(tileType[i][j]);//sets the type of all tiles
                Visual.tiles.add(grid[i][j]);//adds the tiles to the tile container
                
                borderGrid[i][j] = new Border(i, j);//creates all the borders
                borderGrid[i][j].setBorder(borderType[i][j]);//sets the type of all borders
                Visual.tiles.add(borderGrid[i][j],0);//adds the borders to the tile container
                
            }
        }
    }   
}
