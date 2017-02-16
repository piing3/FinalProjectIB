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

    /**
     * Makes a new blank production object
     */
    public Production() {
        this("", "", 0, 0, null);
    }

    public Production(String name, String discription, int buildCost, int goldCost, Icon icon) {
        this.name = name;
        this.discription = discription;
        this.buildCost = buildCost;
        this.goldCost = goldCost;
        this.icon = icon;
    }
    
    


    //----Variables-----------


    
    //----Object-Methods-------

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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
