package GameLogic;

import World.UnitDisplay;
import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class UnitProduction extends Production{

    private int x;
    private int y;
    private int unitType;
    
    
    public UnitProduction(String name, String discription, int buildCost, int goldCost, Icon icon, int x, int y, int unitType) {
        super(name, discription, buildCost, goldCost, icon);
        this.x = x;
        this.y = y;
        this.unitType = unitType;
    }
    
    @Override
    public void built() {
        GameUI.GameVisual.addUnit(x, y, unitType);
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
