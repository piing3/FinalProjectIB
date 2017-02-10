/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *Controls the info and most of the mechanics around the terrain tiles
 * 
 * @author Davin
 */
class Tile extends JLabel{

    
        public int x;//tile's location
        public int y;
        public int tileType;//the tile's type
        public int improvement;//what improvement is on the tile(unimplemented)
        public int movement;//the movement cost of the tile
        public int production;//the production given by the tile
        public int food;//the food given by the tile
        
        public Tile(int i, int j) {
            x = i; y = j;//stores location
            this.setSize(50, 50);//sets bounds
            this.setLocation((x * 50), (y * 50));
        }
    /**
     * sets the tile to the given type
     * @param type: the new type of the tile 
     */
    public void setTile(int type) {
        tileType = type;//stores new type
        if (type == 0 ){//grass
            Icon tile = new ImageIcon("src\\Images\\GrassTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 1;
            food = 1;
        }
        if (type == 1){//dessert
            Icon tile = new ImageIcon("src\\Images\\DessertTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 0;
            food = 0;
        }
        if (type == 2){//water
            Icon tile = new ImageIcon("src\\Images\\WaterTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 0;
            food = 1;
        }
        if (type == 3){//border
            Icon tile = new ImageIcon("src\\Images\\BorderTile1.png");
            this.setIcon(tile);
            production = 0;
            food = 0;
        }
        if (type == 50){//farm improvement
            Icon tile = new ImageIcon("src\\Images\\FarmTile1.png");
            this.setIcon(tile);
            production = 0;
            food = 3;
        }
        if (type == 51){//mine improvement
            Icon tile = new ImageIcon("src\\Images\\MineTile1.png");
            this.setIcon(tile);
            production = 3;
            food = 0;
        }
        if (type == 100){//city
            Icon tile = new ImageIcon("src\\Images\\CityTile1.png");
            this.setIcon(tile);
        }
    }
    /**
     * get the type id of tile 
     * @return the type id  
     */
    static public int getTileType(Tile tile) {
      return tile.tileType;
   }
}
