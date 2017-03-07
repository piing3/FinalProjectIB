package GameLogic;

import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class RangedUnit extends Unit implements Serializable{


    private int damage;
    private int range;
    private boolean movAft;//move after attack
    
    public RangedUnit() {
        this("", "", 0, 0, null, 0, 0, false);
    }

    public RangedUnit(String name, String discription, int buildCost, int goldCost, Icon icon, int defence, int damage, boolean movAft){
        super(name, discription, buildCost, goldCost, icon, defence);
        this.damage = damage;
        this.movAft = movAft;
    }


    //----Variables-----------

    public void setDefence(int defence) {
        this.damage = defence;
    }
    public int getDefence() {
        return damage;
    }

    public boolean canMovAftAtk() {
        return movAft;
    }
    public void setMovAft(boolean movAftAtk) {
        this.movAft = movAftAtk;
    }

    

    
    //----Object-Methods-------

    @Override
    public RangedUnit clone() throws CloneNotSupportedException {
        return (RangedUnit)super.clone();
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
