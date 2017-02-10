package finalProject;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Davin & Ben
 */
public class FinalProject {
public static ArrayList<Unit> units = new ArrayList<Unit>();//list of all units
public static ArrayList<City> cities = new ArrayList<City>();//list of all cities
public static ArrayList<Person> Players = new ArrayList<Person>();//list of players
public static int play;

public static int turnNumber = 0;//current turn number

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        play = 2;//Integer.parseInt(JOptionPane.showInputDialog("How many people are playing"));//gets the number of players, locked at 2 tempariliy
        TurnOrder turnorder = new TurnOrder();
        if (play < 2)JOptionPane.showMessageDialog(null, "you cant play alone.");//Check vailid input
        else if (play > 4) JOptionPane.showMessageDialog(null, "You can only have up to 4 players");
        else {
        for (int i = 0; i < play; i++) {//makes players
            String name = JOptionPane.showInputDialog("What is your name?");
                 if(i == 0) FinalProject.Players.add(new Person(name, i+1));
            else if(i == 1) FinalProject.Players.add(new Person(name, i+1));
            else if(i == 2) FinalProject.Players.add(new Person(name, i+1));
            else if(i == 3) FinalProject.Players.add(new Person(name, i+1));
        }
        FinalProject.Players.get(0).isTurn = true;//begin turns
       Visual visual = new Visual() {
        
            @Override//extra key events here to make Visual neater
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };        
        TurnOrder.spawnStart();//spawn player one
        visual.setVisible(true);//make display visable
        }
    }
}