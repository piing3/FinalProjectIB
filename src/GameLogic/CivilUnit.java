package GameLogic;

import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class CivilUnit extends Unit implements Serializable{

    
    //some sort of variety action (build, settle, etc)
    
    public CivilUnit() {
        this("", "", 0, 0, null, 0);
    }

    public CivilUnit(String name, String discription, int buildCost, int goldCost, Icon icon, int defence){
        super(name, discription, buildCost, goldCost, icon, defence);
    }


    //----Variables-----------

    

    
    //----Object-Methods-------

    @Override
    public CivilUnit clone() throws CloneNotSupportedException {
        return (CivilUnit)super.clone();
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
