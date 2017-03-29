package GameLogic;

import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class BuildingProduction extends Production{

    public static final int BUILDING_WORKSHOP = 0; 
    public static final int BUILDING_FARM = 1;
    public static final int BUILDING_BANK = 2;
    
    public int buildingType;
    
    /**
     * Makes a new building
     * @param name
     * @param discription
     * @param buildCost
     * @param goldCost
     * @param icon
     * @param buildingType
     */
    public BuildingProduction(String name, String discription, int buildCost, int goldCost, Icon icon, int buildingType) {
        super(name, discription, buildCost, goldCost, icon);
        this.buildingType = buildingType;
    }

    @Override
    public void built(City city) {
        city.addBuilding(this);
    }
    
    
    //----Variables-----------

    
    //----Object-Methods-------

    @Override
    public BuildingProduction clone() throws CloneNotSupportedException {
        BuildingProduction b = new BuildingProduction(name, discription, buildCost, goldCost, icon, buildingType);
        return b;
    }

    public boolean equals(BuildingProduction b) {
        if (!super.equals(b)) return false;
        if (this.buildingType != buildingType) return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
