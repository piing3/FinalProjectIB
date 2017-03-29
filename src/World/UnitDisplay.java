package World;

import GameLogic.Turn;
import GameLogic.Unit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author d.holmberg
 */
public class UnitDisplay extends JLabel{

    private int x;//the unit location in tiles
    private int y;

    public UnitDisplay(int x, int y, int type) {
        this(x, y, type, Turn.getTurn());
    }
    
    public UnitDisplay(int x, int y, int type, int playerTurn) {
        this.x = x;
        this.y = y;
        setType(type, playerTurn);
        
        this.setLocation(x*Tile.SIZE, y*Tile.SIZE);
        this.setSize(Tile.SIZE, Tile.SIZE);
        this.setBackground(Color.red);
    }
    
    private void setType(int type, int playerTurn) {
        String color = "";
        if(playerTurn == 0) color = "Blue";
        if(playerTurn == 1) color = "Green";
        if(playerTurn == 2) color = "Red";
        if(playerTurn == 3) color = "Pink";
        
        if(type == Unit.UNIT_WARRIOR){
            this.setIcon(new ImageIcon("src\\Resources\\UnitIcons\\Warrior"+color+".png"));
        }
        if(type == Unit.UNIT_ARCHER){
            this.setIcon(new ImageIcon("src\\Resources\\UnitIcons\\Archer"+color+".png"));
        }
        if(type == Unit.UNIT_SCOUT){
            this.setIcon(new ImageIcon("src\\Resources\\UnitIcons\\Scout"+color+".png"));
        }
        if(type == Unit.UNIT_SETTLER){
            this.setIcon(new ImageIcon("src\\Resources\\UnitIcons\\Settler"+color+".png"));
        }
        if(type == Unit.UNIT_BUILDER){
            this.setIcon(new ImageIcon("src\\Resources\\UnitIcons\\Builder"+color+".png"));
        } 
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