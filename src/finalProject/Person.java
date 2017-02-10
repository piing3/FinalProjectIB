/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.ArrayList;
import java.util.Random;

/**
 *Controls and stores info on the players
 * 
 * @author Ben
 */
class Person {
    String name;//the entered name
    public int PlayerNumber;//the players index
    public boolean isTurn;// stores if it's their turn
    public int players = FinalProject.play;//the amount of players playing
    public ArrayList<Integer> buildObjects = new ArrayList<Integer>();// the list of unlocked builds for the player
    public int startX;//their starting x
    public int startY;//their starting y
    
    public Person(String name, int playerNumber) {
       
        this.name = name;//stores their name
        this.PlayerNumber = playerNumber;//stores their playerNumber
        
        buildObjects.add(0);//adds all avalable builds to the player's list
        buildObjects.add(1);
        buildObjects.add(3);
        buildObjects.add(2);
        buildObjects.add(4);
        buildObjects.add(25);
        buildObjects.add(24);
        buildObjects.add(23);
        buildObjects.add(22);
    }
}
