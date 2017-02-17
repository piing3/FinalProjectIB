package Logic;

import javax.swing.Icon;

/**
 *
 * @author d.holmberg
 */
public class Building extends Production{

    private int productionChange;
    private int goldChange;
    
    /**
     * Makes a new blank building object 
     */
    public Building() {
        super();
        this.productionChange = 0;
        this.goldChange = 0;
    }
    
    /**
     * Makes a new building
     * @param name
     * @param discription
     * @param buildCost
     * @param goldCost
     * @param icon
     * @param productionChange
     * @param goldChange 
     */
    public Building(String name, String discription, int buildCost, int goldCost, Icon icon, int productionChange, int goldChange) {
        super(name, discription, buildCost, goldCost, icon);
        this.productionChange = productionChange;
        this.goldChange = goldChange;
    }
    
    //----Variables-----------

    public int getProductionChange() {
        return productionChange;
    }
    public void setProductionChange(int productionChange) {
        this.productionChange = productionChange;
    }

    public int getGoldChange() {
        return goldChange;
    }
    public int getGoldCost() {
        return goldCost;
    }
    
    //----Object-Methods-------

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Building b = new Building(name, discription, buildCost, goldCost, icon, productionChange, goldChange);
        b.setBuilt(built);
        return b;
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
