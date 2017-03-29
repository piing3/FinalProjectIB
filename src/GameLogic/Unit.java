package GameLogic;

import GameVisual.UserInt;
import Utill.Globals;
import World.Map;
import GameVisual.UnitDisplay;
import java.awt.Point;

/**
 * Purpose: 
 * @author Davin
 *
 */
public class Unit {

    private int player;
    
    private String name;
    int x, y;
    private int movementMax = 2, movementCur = 2;
    
    private int health = 100; 
    private int mDamage = 0, mDefence = 0;
    private int range = 0, rDamage = 0, rDefence = 0;
    
    private int builds = 0; 
    private boolean settle = false;
    
    private UnitDisplay display; 
    
    private static Unit selectedUnit;

    public static final int UNIT_WARRIOR = 0; 
    public static final int UNIT_ARCHER = 1; 
    public static final int UNIT_SCOUT = 3; 
    public static final int UNIT_SETTLER = 3; 
    public static final int UNIT_BUILDER = 4; 
    
    public Unit(int unit, int x, int y, int player) {
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
            this.settle = true;
        }
        if(unit == UNIT_BUILDER){
            this.name = "Builder";
            this.builds = 3;
        }
        
        display = new UnitDisplay(x, y, unit, player);
        GameVisual.GameVisual.worldAdd(display);
    }
    
    public static int findUnit(int tileX, int tileY) {
        for (int i = 0; i < Globals.unitList.size(); i++) {
            if (Globals.unitList.get(i).x == tileX && Globals.unitList.get(i).y == tileY) {
                return i;
            }
        }
        return -1;
    }

    public void kill() {
        display.setVisible(false);
        display = null;
    }

    public static void MoveGround(int index, int newX, int newY){
        Unit unit = Globals.unitList.get(index);
        if(unit.x == newX && unit.y == newY) return;
        if(findUnit(newX, newY) != -1) return; 
        if(!World.Map.checkTileLand(newX, newY) || unit.movementCur <= 0) return;
        if(Turn.getTurn() != unit.player) return;
        
        if (unit.x + 1 == newX || unit.x -1 == newX || unit.x == newX){
            if (unit.y + 1 == newY || unit.y -1 == newY || unit.y == newY){
                unit.x = newX;
                unit.y = newY;
                unit.movementCur--;
                UserInt.setMovingUnit(false);
                Map.redrawUnits();
                                                                                                                                                                                                                                                                                                                                                                                                            
            }
        }
    }
    
    
    public void startTurn() {
        movementCur = movementMax;
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
    public boolean canSettle() {
        return settle;
    }

    public int getPlayer() {
        return player;
    }
    
    public static Unit getSelectedUnit() {
        return selectedUnit;
    }

    public static void setSelectedUnit(Unit selectedUnit) {
        Unit.selectedUnit = selectedUnit;
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
