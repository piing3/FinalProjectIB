/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Used to store the info about each city
 * and does most of the city logic
 *
 * @author Davin
 */
class City extends JLabel{
    
    public int x;//location
    public int y;
    
    public int production = 1;//city info 
    public int gold = 0;
    public int population = 3;
    public int food = 0;
    
    public int growthLeft;//used for adding population
    public int productionLeft;//used for building things
    public Prodution productionItem = new Prodution(-1);//the item being built
    
    public int Health = 100;//city combat numbers, unused
    public int Damage = 20;
    
    public String name = "";//city name
    public Person owner;//city owner
    
    public ArrayList<Integer> cityBuildObjects = new ArrayList<Integer>();//can be built objects 
    public ArrayList<Integer> BuiltObjects = new ArrayList<Integer>();//built objects 
    
    City(int x, int y, int Owner) {
        this.x = x;//stores location
        this.y = y;
        this.owner = FinalProject.Players.get(Owner);//stores owner
        
        Map.tileType[x][y] = 100;//sets the grid location to a city...
        Visual.redrawMap();//... and redraws the map
        
        name = JOptionPane.showInputDialog("Name this city");//name the city
            
        for (int i = 0; i < this.owner.buildObjects.size(); i++) {
            this.cityBuildObjects.add(this.owner.buildObjects.get(i));//fills the buildable object list
        }
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                Tile tile = Map.grid[this.x + i][this.y + j];//get food and production from tiles
                this.production += tile.production;
                this.food += tile.food;
                
                Map.borderGrid[this.x + i][this.y + j].setBorder(1);//set borders on tiles
                Map.borderType[this.x + i][this.y + j] = TurnOrder.whoTurn();
                Visual.redrawMap();
            }
        }
    }
    City() {//makes a blank city
    }
    
    
    /**
     * sets the gold in the given city
     * 
     * @param city
     * @param newGold: the new gold  
     */
    public void setGold(City city, int newGold){
        city.gold = newGold;
    }
    /**
     * sets the production in the given city
     * 
     * @param city
     * @param newProduction : the new production  
     */
    public void setProduction(City city, int newProduction){
        city.production = newProduction;
    }
    /**
     * sets the population in the given city
     * 
     * @param city
     * @param newPopulation : the new population
     */
    public void setPopulation(City city, int newPopulation){
        city.population = newPopulation;
    } 
    /**
     * sets the food in the given city
     * 
     * @param city
     * @param newFood: the new food
     */
    public void setFood(City city, int newFood){
        city.food = newFood;
    }  
    
    /**
     * gets the gold from the given city
     * 
     * @param city
     * @return gold
     */
    public int getGold(City city){
        return city.gold;
    }  
    /**
     * gets the production from the given city
     * 
     * @param city
     * @return production
     */
    public int getProduction(City city){
        return city.production;
    }
    /**
     * gets the population from the given city
     * 
     * @param city
     * @return population
     */
    public int getPopulation(City city){
        return city.population;
    }  
    /**
     * gets the food from the given city
     * 
     * @param city
     * @return food
     */
    public int getFood(City city){
        return city.food;
    }  
    
    /**
     * Updates all cities belonging to the given player
     * 
     * @param owner: the player
     */
    public static void updateCity(Person owner){
        for (int i = 0; i < FinalProject.cities.size(); i++) {//for each city...
            City city = FinalProject.cities.get(i);
            if (city.owner == owner){//...if the owner is the given owner 
                if (city.productionLeft > 0) city.productionLeft -= city.production; //lower the city's productionLeft by the city's production 
                
                if (city.productionLeft <= 0) {//if the production is finished
                    
                    if (!city.productionItem.rebuildable) {//if it's not rebuildable
                        
                        for (int j = 0; j < city.cityBuildObjects.size(); j++) {//find the index of the finished object and remove it from the list 
                            if (city.cityBuildObjects.get(j) == city.productionItem.number)  city.cityBuildObjects.remove(j);
                        }
                    }
                    
                    if (city.productionItem.isUnit) UnitType.CreateUnit(city.x, city.y, city.productionItem.unitType, Visual.Units);//if it's a unit, make it
                    city.BuiltObjects.add(city.productionItem.number);//add the object to the finished builds list
                    city.productionItem = new Prodution(-1);//clear the city's productionItem
                }
                
                city.growthLeft -= city.food;//lower the city's growthLeft by the city's food 
                
                if (city.growthLeft <= 0) {//if the growthLeft is done, increse population and set the new growthLeft
                    city.population++;
                    city.growthLeft = city.population*3;
                }
                
                city.production = 1;//reset to default food and production
                city.food = 0;
                
                for (int j = 0; j < city.BuiltObjects.size(); j++) {//add the gold and production from all finished builds
                    city.gold += new Prodution(city.BuiltObjects.get(j)).goldChange;
                    city.production += new Prodution(city.BuiltObjects.get(j)).productionChange;
                }
                
                for (int j = -2; j < 3; j++) {//add the food and production from surounding tiles
                    for (int k = -2; k < 3; k++) {
                        Tile tile = Map.grid[city.x + j][city.y + k];
                        city.production += tile.production;
                        city.food += tile.food;
                    }
                }
                city.food -= city.population*2;//lower the food by twice the population
                city.production += city.population/2;//add half the population to the production
            }
        }
    }
}
