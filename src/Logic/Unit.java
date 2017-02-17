package Logic;

import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class Unit extends Production{

    private int unitType;

    public Unit() {
        super();
        this.unitType = 0;
    }

    public Unit(String name, String discription, int buildCost, int goldCost, Icon icon, int unitType) {
        super(name, discription, buildCost, goldCost, icon);
        this.unitType = unitType;
    }

    //----Variables-----------

    public int getUnitType() {
        return unitType;
    }
    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }
    
    //----Object-Methods-------

    @Override
    public Unit clone() throws CloneNotSupportedException {
        Unit u = new Unit(name, discription, buildCost, goldCost, icon, unitType);
        u.setBuilt(built);
        return u;
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
