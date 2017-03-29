package Main;

import GameLogic.City;
import GameLogic.Player;
import GameLogic.Production;
import GameLogic.Unit;
import GameUI.UserInput;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Stores public static variables used across the project.
 * "if it's used in multiple packages, it probably should be here"
 * @author d.holmberg
 */
public abstract class Globals {

    public static boolean initalized = false;
    
    public static ArrayList<Unit> unitList = new ArrayList<Unit>();//the list that stores unit
    public static ArrayList<Player> playerList = new ArrayList<Player>();
    public static ArrayList<City> cityList = new ArrayList<City>();//list of all cityList
    public static Production[] buildList = new Production[100];
    public static Settings settings = new Settings();
    public static UserInput userInput = new UserInput();
    
    public static void initalize() {
        Production.fillList();
        Settings.writeFile();
        Settings.readFile();    
        
        initalized = true;
    }
    
    public static void stop(){
        
    }
    
    //----Variables-----------

    public void removePlayer(Player player){
        for (int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).equals(player)){
                playerList.remove(i);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: Player not found");
    }
}
