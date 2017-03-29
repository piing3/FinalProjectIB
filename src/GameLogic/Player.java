package GameLogic;

import Main.Globals;
import World.Map;
import java.util.ArrayList;
import java.util.Random;

/**
 * A player object
 * 
 * @author Davin
 */
public class Player {

    private String name;
    private int startX;
    private int startY;
    private ArrayList<Integer> buildList = new ArrayList<Integer>();
    
    private int gold;
    
    /**
     * Empty player with a empty string for 'name'
     */
    public Player() {
        this("");
    }

    /**
     * Empty player with the given string for 'name'
     * @param name 
     */
    public Player(String name) {
        this.name = name;
        this.startX = 0;
        this.startY = 0;
        
        startBuildList();
    }

    /**
     * I don't like this, seems sloppy
     */
    private void startBuildList() {
    
        buildList.add(0);
        buildList.add(1);
        buildList.add(2);
        buildList.add(3);
        buildList.add(4);
        buildList.add(5);
        buildList.add(6);
        
    }
    
    /**
     * Generates the visual elements at a semi-random location  
     */
    public void spawn(int index){
        Random r = new Random();
        do{
            startX = r.nextInt(Map.MAP_WIDTH);
            startY = r.nextInt(Map.MAP_HEIGHT);
        }while (!Map.checkTileLand(startX, startY));
        GameUI.GameVisual.addUnit(startX, startY, Unit.UNIT_SETTLER, index);
    }
    
    
    public void startTurn() {
        for (int i = 0; i < Globals.cityList.size(); i++) {
            Player p = Globals.playerList.get(Globals.cityList.get(i).getPlayer());
            if(p == this){
                Globals.cityList.get(i).startTurn();
            }
        }
        for (int i = 0; i < Globals.unitList.size(); i++) {
            Player p = Globals.playerList.get(Globals.unitList.get(i).getPlayer());
            if (p == this) {
                Globals.unitList.get(i).startTurn();
            }
        }
        
    }
    
    //----Variables-----------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStartX() {
        return startX;
    }
    public void setStartX(int startX) {
        this.startX = startX;
    }
    
    public int getStartY() {
        return startY;
    }
    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void changeGold(int change) {
        gold += change;
    }

    public ArrayList<Integer> getBuildList() {
        return buildList;
    }

    
    
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