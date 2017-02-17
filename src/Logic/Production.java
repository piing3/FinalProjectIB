package Logic;

import javax.swing.Icon;

/**
 * An object that can be built in cities
 * 
 * @author Davin
 */
public class Production {
    
    String name; // the object's display name
    String discription; // a brief discription of the object
    int buildCost; // the amount of product needed to build this object
    int goldCost; // the amount of product needed to build this object
    Icon icon; // the icon used in the build menu
    
    Runnable built; // a special action run when the object is built

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
        
        built = new Runnable() {
            @Override
            public void run() {
            }
        };
    }
    
    /**
     * Run when the object is built
     */
    public void Built(){
        built.run();
    }
    
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

    public Runnable getBuilt() {
        return built;
    }
    public void setBuilt(Runnable built) {
        this.built = built;
    }
    
    
    //----Object-Methods-------

    @Override
    public Production clone() throws CloneNotSupportedException {
        Production p = new Production(name, discription, buildCost, goldCost, icon);
        p.setBuilt(built);
        return p;
    }

    @Override
    public boolean equals(Object obj) {
        Production p = (Production) obj;
        if (this.name != p.name) return false;
        if (this.discription != p.discription) return false;
        if (this.buildCost != p.buildCost) return false;
        if (this.goldCost != p.goldCost) return false;
        if (this.icon != p.icon) return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
   
}
