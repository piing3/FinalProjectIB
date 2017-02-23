package Logic;

import java.io.Serializable;
import javax.swing.Icon;

/**
 * An object that can be built in cities
 * 
 * @author Davin
 */
public class Production implements Serializable{
    
    protected String name; // the object's display name
    protected String discription; // a brief discription of the object
    protected int buildCost; // the amount of product needed to build this object
    protected int goldCost; // the amount of product needed to build this object
    protected Icon icon; // the icon used in the build menu
    
    /**
     * Makes a new blank production object
     */
    protected Production() {
        this("", "", 0, 0, null);
    }
    
    /**
     * Makes a new production object
     * @param name
     * @param discription
     * @param buildCost
     * @param goldCost
     * @param icon 
     */
    protected Production(String name, String discription, int buildCost, int goldCost, Icon icon) {
        this.name = name;
        this.discription = discription;
        this.buildCost = buildCost;
        this.goldCost = goldCost;
        this.icon = icon;
    }
    
    /**
     * Run when the object is built
     */
    
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

    @Override
    public Production clone() throws CloneNotSupportedException {
        Production p = new Production(name, discription, buildCost, goldCost, icon);
        return p;
    }

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
