package Main;

import Logic.BuildIndex;
import World.City;
import Logic.Player;
import Logic.TurnOrder;
import World.Unit;
import UI.Visual;
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Globals.initalize();
        
        MainMenu.display();
        
   
    }
}