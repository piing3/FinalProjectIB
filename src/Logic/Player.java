package Logic;

import java.util.ArrayList;//replace with my own

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
        
    }
    
    /**
     * Generates the visual elements at a semi-random location  
     */
    public void spawn(){
        //todo
    }
    
    /**
     * Runs when a players turn starts
     */
    public void startTurn(){
        //todo
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