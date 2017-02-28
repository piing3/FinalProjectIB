package Main;

import Logic.BuildIndex;
import Logic.Player;
import Logic.Production;
import UI.BaseFrame;
import World.City;
import World.Unit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Stores public static variables used across the project.
 * "if it's used in multiple packages, it probably should be here"
 * @author d.holmberg
 */
public class Globals {


    public static int unitGrid[][];//the grid that stores unit positions 
    public static ArrayList<Player> players = new ArrayList<Player>();
    public static ArrayList<City> cities = new ArrayList<City>();//list of all cities
    public static ArrayList<Unit> units = new ArrayList<Unit>();//list of all units
    public static Production[] buildList = new Production[100];
    public static BaseFrame baseFrame = new BaseFrame();
    
    public static void initalize() {
        BuildIndex.readFile();
        baseFrame.setVisible(true);
    }
    
    
    


    //----Variables-----------

    public void removePlayer(Player player){
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).equals(player)){
                players.remove(i);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: Player not found");
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
