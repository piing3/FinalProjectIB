package GameLogic;

import Main.Globals;
import Main.Visual;
import World.Tile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Purpose: 
 * @author Davin
 *
 */
public class City {

    private int x;//location
    private int y;
    
    private int production = 1;//city default info 
    private int gold = 0;
    private int population = 1;
    private int food = 0;
    private int science = 0;
    
    private int growthLeft = 0;//used for adding population
    private int productionRemain = 0;//used for building things
    private Production productionItem = null;//the item being built
    
    private int Health = 100;//city combat numbers, unused
    private int Damage = 20;
    
    private String name = "";//city name
    private int player;//city owner
    
    private ArrayList<BuildingProduction> BuiltObjects = new ArrayList<BuildingProduction>();//built objects 

    public City(int x, int y, int player) {
        this.name = JOptionPane.showInputDialog(Main.Visual.getBaseFrame(), "Name your new city:");
        
        this.x = x;
        this.y = y;
        this.player = player;
        
        World.Map.setTile(x, y, Tile.TILE_CITY);
        
    }
    
    
    public static int findCity(int tileX, int tileY){
        for (int i = 0; i < Main.Globals.cityList.size(); i++) {
            if (Globals.cityList.get(i).x == tileX && Globals.cityList.get(i).y == tileY) {
                return i;
            }
        }
        return -1;
    }
    
    public void startTurn() {
        growthLeft -= (food-population*2);
        if(growthLeft <= 0) {
            population++;
            growthLeft = population*3;
        }
        productionRemain -= production;
        if (productionRemain <= 0 && productionItem != null) {
            productionItem.built(this);
            productionItem = null;
        }
        Globals.playerList.get(player).changeGold(gold);
    }

    //------Varibles-Methods------------

    
    public void addBuilding(BuildingProduction building) {
        BuiltObjects.add(building);
        if (building.buildingType == BuildingProduction.BUILDING_WORKSHOP) {
            production += 2;
        }
        if (building.buildingType == BuildingProduction.BUILDING_FARM) {
            food += 2;
        }
        if (building.buildingType == BuildingProduction.BUILDING_BANK) {
            gold += 2;
        }
    }

    public int getFood() {
        return food;
    }

    public int getGold() {
        return gold;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getProduction() {
        return production;
    }

    public Production getProductionItem() {
        return productionItem;
    }

    public void setProductionItem(Production productionItem) {
        this.productionItem = productionItem;
        this.productionRemain = productionItem.buildCost;
    }

    public int getProductionRemain() {
        return productionRemain;
    }
    
    public int getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    

    //-------Object-Methods------------- 

    @Override
    public Object clone() throws CloneNotSupportedException {
        return this;
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
