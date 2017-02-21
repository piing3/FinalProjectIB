package Logic;

import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class MeleeUnit extends Unit implements Serializable{


    private int damage;
    private boolean movAft;//move after attck
    
    public MeleeUnit() {
        this("", "", 0, 0, null, 0, 0, false);
    }

    public MeleeUnit(String name, String discription, int buildCost, int goldCost, Icon icon, int defence, int damage, boolean movAft){
        super(name, discription, buildCost, goldCost, icon, defence);
        this.damage = damage;
        this.movAft = movAft;
    }


    //----Variables-----------

    public void setDamage(int defence) {
        this.damage = defence;
    }
    public int getDamage() {
        return damage;
    }

    public boolean canMovAftAtk() {
        return movAft;
    }
    public void setMovAftAtk(boolean movAftAtk) {
        this.movAft = movAftAtk;
    }

    

    
    //----Object-Methods-------

    @Override
    public MeleeUnit clone() throws CloneNotSupportedException {
        return (MeleeUnit)super.clone();
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
