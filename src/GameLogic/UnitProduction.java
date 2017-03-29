package GameLogic;

import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class UnitProduction extends Production{

    private int unitType;
    
    
    public UnitProduction(String name, String discription, int buildCost, int goldCost, Icon icon, int unitType) {
        super(name, discription, buildCost, goldCost, icon);
        this.unitType = unitType;
    }
    
    @Override
    public void built(City city) {
        GameVisual.GameVisual.addUnit(city.getX(), city.getY(), unitType, Turn.getTurn());
    }
    
    //----Variables-----------
    
    

    //----Object-Methods-------

    @Override
    public UnitProduction clone() throws CloneNotSupportedException {
        return (UnitProduction) super.clone();
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
