package GameLogic;

import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class BuildingProduction extends Production{

    private City city;
    public int buildingType;
    
    /**
     * Makes a new building
     * @param name
     * @param discription
     * @param buildCost
     * @param goldCost
     * @param icon
     * @param city
     * @param buildingType
     */
    public BuildingProduction(String name, String discription, int buildCost, int goldCost, Icon icon, City city, int buildingType) {
        super(name, discription, buildCost, goldCost, icon);
        this.city = city;
        this.buildingType = buildingType;
    }

    @Override
    public void built() {
        city.addBuilding(this);
    }
    
    
    //----Variables-----------

    
    //----Object-Methods-------

    @Override
    public BuildingProduction clone() throws CloneNotSupportedException {
        BuildingProduction b = new BuildingProduction(name, discription, buildCost, goldCost, icon, city, buildingType);
        return b;
    }

    public boolean equals(BuildingProduction b) {
        if (!super.equals(b)) return false;
        if (!this.city.equals(b.city)) return false;
        if (this.buildingType != buildingType) return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }



}
