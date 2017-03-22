package GameLogic;

import Main.Globals;
import World.UnitDisplay;
import java.awt.Point;

/**
 * Purpose: 
 * @author Davin
 *
 */
public class Unit {

    private String name;
    private int x, y;
    private int movementMax = 2, movementCur = 0;
    
    private int health = 100; 
    private int mDamage = 0, mDefence = 0;
    private int range = 0, rDamage = 0, rDefence = 0;
    
    private int builds = 0, settles = 0;
    
    private int multiCount = 1;
    private UnitDisplay display; 

    public static final int UNIT_WARRIOR = 0; 
    public static final int UNIT_ARCHER = 1; 
    public static final int UNIT_SCOUT = 3; 
    public static final int UNIT_SETTLER = 3; 
    public static final int UNIT_BUILDER = 4; 
    
    public Unit(int unit, int x, int y) {
        this.x = x; this.y = y;
        
        if(unit == UNIT_WARRIOR){
            this.name = "Warrior";
            this.mDamage = 30; mDefence = 15;
            this.rDefence = 10;
            
        }
        if(unit == UNIT_ARCHER){
            this.name = "Archer";
            this.mDefence = 5;
            this.range = 2; this.rDamage = 30; this.rDefence = 5;
        }
        if(unit == UNIT_SCOUT){
            this.name = "Scout";
            this.movementMax = 4;
            this.mDamage = 20; mDefence = 5;
            this.rDefence = 10;
        }
        if(unit == UNIT_SETTLER){
            this.name = "Settler";
            this.settles = 1;
        }
        if(unit == UNIT_BUILDER){
            this.name = "Builder";
            this.builds = 3;
        }
        
        display = new UnitDisplay(x, y, unit);
        GameUI.GameVisual.worldAdd(display);
    }
    
    public static int findUnit(int tileX, int tileY) {
        for (int i = 0; i < Globals.unitList.size(); i++) {
            if (Globals.unitList.get(i).x == tileX && Globals.unitList.get(i).y == tileY) {
                return i;
            }
        }
        return -1;
    }

    //------Varibles-Methods------------

    public Point getPos() {
        return new Point(x, y);
    }
    public UnitDisplay getDisplay(){
        return display;
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMovementCur() {
        return movementCur;
    }
    

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
