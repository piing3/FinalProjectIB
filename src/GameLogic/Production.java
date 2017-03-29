package GameLogic;

import Main.Globals;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * An object that can be built in cityList
 * 
 * @author Davin
 */
public abstract class Production{
    
    protected String name; // the object's display name
    protected String discription; // a brief discription of the object
    protected int buildCost; // the amount of product needed to build this object
    protected int goldCost; // the amount of product needed to build this object
    protected Icon icon; // the icon used in the build menu
    
    /**
     * Makes a new production object
     * @param name
     * @param discription
     * @param buildCost
     * @param goldCost
     * @param icon 
     */
    public Production(String name, String discription, int buildCost, int goldCost, Icon icon) {
        this.name = name;
        this.discription = discription;
        this.buildCost = buildCost;
        this.goldCost = goldCost;
        this.icon = icon;
    }
    
    public abstract void built(City city);
    
    public static void fillList(){
        Globals.buildList = new Production[100];
        
        Globals.buildList[0] = new UnitProduction("Warrior", "Basic melee unit", 3, 100, null, Unit.UNIT_WARRIOR);
        Globals.buildList[1] = new UnitProduction("Archer", "Basic ranged unit", 3, 120, null, Unit.UNIT_ARCHER);
        Globals.buildList[2] = new UnitProduction("Settler", "Can make a new city", 4, 250, null, Unit.UNIT_SETTLER);
        Globals.buildList[3] = new UnitProduction("Worker", "Can build and repair tile improvements", 3, 100, null, Unit.UNIT_BUILDER);
        Globals.buildList[4] = new BuildingProduction("Workshop", "Raises the city's production", 2, 200, null, BuildingProduction.BUILDING_WORKSHOP);
        Globals.buildList[5] = new BuildingProduction("Farm", "Raises the city's food", 2, 200, null, BuildingProduction.BUILDING_FARM);
        Globals.buildList[6] = new BuildingProduction("Bank", "Raises the city's gold", 2, 200, null, BuildingProduction.BUILDING_BANK);
    } 
    
    //----Variables-----------

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
    
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    public void setBuildCost(int buildCost) {
        this.buildCost = buildCost;
    }
    public int getBuildCost() {
        return buildCost;
    }

    public int getGoldCost() {
        return goldCost;
    }
    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }

    public Icon getIcon() {
        return icon;
    }
    public void setIcon(Icon icon) {
        this.icon = icon;
    }    
    
    //----Object-Methods-------

    public boolean equals(Production p) {
        if (this.name != p.name) return false;
        if (this.discription != p.discription) return false;
        if (this.buildCost != p.buildCost) return false;
        if (this.goldCost != p.goldCost) return false;
        if (!this.icon.equals(p.icon)) return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
   
}
