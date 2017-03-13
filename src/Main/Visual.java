package Main;

import GameUI.GameVisual;
import GameUI.PauseMenu;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * Master class for all application visuals.
 * @author d.holmberg
 */
public class Visual{
    
    protected static BaseFrame baseFrame;
    private static boolean gameStart = false;
    
    static void initalize() {
        baseFrame = new BaseFrame(Globals.settings.getDimension(100, 100));
        baseFrame.setVisible(true);
    }
    
    public static void MainMenu(){
        if (baseFrame == null){
            initalize();
        }
        
        MainMenu.display();
    }
    
    public static void Game(){
        if (baseFrame == null){
            GameVisual.display();
        }
        gameStart = true;
    }
    
    protected static void userInput(KeyEvent e) {
        if (gameStart){
            GameVisual.userInput(e);
        }
    }
    
    protected static void userInput(MouseEvent e) {
        if (gameStart){
            GameVisual.userInput(e);
        }
    }
      
    //----Variables-----------
  
    
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
