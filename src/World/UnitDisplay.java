package World;

import javax.swing.JLabel;

/**
 * 
 * @author d.holmberg
 */
public class UnitDisplay extends JLabel{

    private int x;//the unit location in tiles
    private int y;
    
    private int type;
    public final int WARRIOR = 0; 
    public final int ARCHER = 1; 
    public final int SCOUT = 2; 
    public final int SETTLER = 3; 

    
    
    public UnitDisplay(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        
        this.setLocation(x*Tile.SIZE, y*Tile.SIZE);
        this.setSize(Tile.SIZE, Tile.SIZE);
        
    }    

    //------Varibles-Methods------------



    //-------Object-Methods------------- 

    @Override
    public Object clone() throws CloneNotSupportedException {
        return this;
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

package World;

import GameUI.UserInt;
import UI.Visual;
import java.awt.Container;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * to clean 
 *creates and stores info on units
 * 
 * @author Ben Allen

public class UnitDisplay extends JLabel{

    int player;//the owner
    public int  movement;//the units current movement 
    int x;//the units location
    int y;
    int defaultMove;//the units normal movement
    int type = -1;//the units type
    int health;//the units health
    Icon UnitDisplay; //the image displayed on the map
    Icon unitIcon; //the image displayed in the UI
    String name;//the units name
    public int Damage;//the units damage
    
    UnitDisplay(int x, int y, int type, Container container, int owner) {
        container.add(this,1);//adds the unit t container
        this.x = x;//stores grid location
        this.y = y;
        this.setSize(50, 50);//set label size
        this.setLocation(x*50, y*50);//set location
        this.player = owner;//stores owner
        Visual.LoadUnits();//reloads unit display
        if (type == 1){
            this.name = "Warrior";
            this.unitIcon = new ImageIcon("src\\Images\\WarriorIcon.png");
            this.defaultMove = 2;
            this.health = 60;
            this.Damage = 10;
        }
        if (type == 2){
            this.name = "Settler";
            this.unitIcon = new ImageIcon("src\\Images\\WarriorIcon.png");
            this.defaultMove = 2;
            this.health = 40;
            this.Damage = 0;
        }
        if (type == 3){
            this.name = "Archer";
            this.unitIcon = new ImageIcon("src\\Images\\WarriorIcon.png");
            this.defaultMove = 2;
            this.health = 50;
            this.Damage = 15;
        }
        if (type == 4) {
            this.unitIcon = new ImageIcon("src\\Images\\WarriorUnit1.png");
            this.defaultMove = 4;
            this.health = 60;
            this.Damage = 15;
        }
        movement = defaultMove;
    }
    public void SetMove(UnitDisplay unit){ unit.movement = unit.defaultMove; UserInt.updateMoves();}// resets the units movement
    /**
     * sets the map image to the given type and color based of who's turn it is
     * @param type 
    
    public  void setUnit(int type) {
        this.type = type;//stores type
        if (type == -1){//blank
            UnitDisplay = null;
            this.setIcon(UnitDisplay);
        }

        if (type == 1){//warrior
                 if (this.player == 1) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\WarriorPink.png");
            else if (this.player == 2) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\WarriorRed.png");
            else if (this.player == 3) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\WarriorGreen.png");
            else if (this.player == 4) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\WarriorBlue.png");
            this.setIcon(UnitDisplay);
        }
        if (type == 2) {//settler
                 if (this.player == 1) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\SettlerPink.png");
            else if (this.player == 2) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\SettlerRed.png");
            else if (this.player == 3) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\SettlerGreen.png");
            else if (this.player == 4) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\SettlerBlue.png");
            this.setIcon(UnitDisplay);
        }
        if (type == 3) {//archer
                 if (this.player == 1) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\ArcherPink.png");
            else if (this.player == 2) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\ArcherRed.png");
            else if (this.player == 3) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\ArcherGreen.png");
            else if (this.player == 4) UnitDisplay = new ImageIcon("src\\Images\\UnitIcons\\ArcherBlue.png");
            this.setIcon(UnitDisplay);
        }
        if (type == 4) {//boat
                 if (this.player == 1) UnitDisplay = new ImageIcon("src\\Images\\WarriorUnit1.png");
            else if (this.player == 2) UnitDisplay = new ImageIcon("src\\Images\\WarriorUnit1.png");
            else if (this.player == 3) UnitDisplay = new ImageIcon("src\\Images\\WarriorUnit1.png");
            else if (this.player == 4) UnitDisplay = new ImageIcon("src\\Images\\WarriorUnit1.png");
            this.setIcon(UnitDisplay);
        }
        
        
    }
    UnitDisplay(){
        //used for making blank units
    }
}


*/