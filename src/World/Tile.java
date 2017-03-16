package World;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author d.holmberg
 */
public class Tile extends JLabel{

    public static final int SIZE = 50;
    
    private int x;
    private int y;
    private int tileType;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.tileType = -1;
        
        this.setSize(SIZE, SIZE);
        this.setLocation(x*SIZE, y*SIZE);
    }
    
    


    //----Variables-----------

    /**
    * Sets the 'tyleType' value and the tile image
    * @param type 
    */
    public void setTile(int type){
        tileType = type;
        String file = "src\\Resources\\";
        if (tileType == 0) file += "GrassTile1.png";
        if (tileType == 1) file += "DessertTile1.png";
        if (tileType == 2) file += "WaterTile1.png";
        if (tileType == 3) file += "BorderTile1.png";
        
        this.setIcon(new ImageIcon(file));
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

/* Lagacy Code
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
package World;

import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *Controls the info and most of the mechanics around the terrain tiles
 * 
 * @author Davin
 *
//class Tile extends JLabel{

    
    private int x;//tile's location
    private int y;
    private int tileType;//the tile's type
    private int improvement;//what improvement is on the tile(unimplemented)
    private int movement;//the movement cost of the tile
    private int production;//the production given by the tile
    private int food;//the food given by the tile


    public static final int SIZE = 50;

    public Tile(int i, int j) {
        x = i; y = j;//stores location
        this.setSize(SIZE, SIZE);//sets bounds
        this.setLocation((x * SIZE), (y * SIZE));
    }
    /**
     * sets the tile to the given type
     * @param type: the new type of the tile 
     *
    public void setTile(int type) {
        tileType = type;//stores new type
        if (type == 0 ){//grass
            Icon tile = new ImageIcon("src\\Resources\\GrassTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 1;
            food = 1;
        }
        if (type == 1){//dessert
            Icon tile = new ImageIcon("src\\Resources\\DessertTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 0;
            food = 0;
        }
        if (type == 2){//water
            Icon tile = new ImageIcon("src\\Resources\\WaterTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 0;
            food = 1;
        }
        if (type == 3){//border
            Icon tile = new ImageIcon("src\\Resources\\BorderTile1.png");
            this.setIcon(tile);
            production = 0;
            food = 0;
        }
        if (type == 50){//farm improvement
            Icon tile = new ImageIcon("src\\Resources\\FarmTile1.png");
            this.setIcon(tile);
            production = 0;
            food = 3;
        }
        if (type == 51){//mine improvement
            Icon tile = new ImageIcon("src\\Resources\\MineTile1.png");
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
     *
    static public int getTileType(Tile tile) {
      return tile.tileType;
   }
}

*/