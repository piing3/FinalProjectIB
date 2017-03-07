package GameLogic;

import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class Unit extends Production implements Serializable{

    private int defence;
    private int speed;

    public Unit() {
        super();
        this.defence = 0;
    }

    public Unit(String name, String discription, int buildCost, int goldCost, Icon icon, int defence) {
        super(name, discription, buildCost, goldCost, icon);
        this.defence = defence;
    }

    //----Variables-----------

    public int getUnitType() {
        return defence;
    }
    public void setUnitType(int unitType) {
        this.defence = unitType;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
    
    //----Object-Methods-------

    @Override
    public Unit clone() throws CloneNotSupportedException {
        Unit u = new Unit(name, discription, buildCost, goldCost, icon, defence);
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