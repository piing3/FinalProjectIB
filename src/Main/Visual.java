package Main;

import GameUI.GameVisual;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Master class for all application visuals.
 * @author d.holmberg
 */
public class Visual{
    
    public static boolean initalized = false;
    
    protected static BaseFrame baseFrame;
    private static boolean gameStart = false;
    
    public static void initalize() {
        if (!Globals.initalized) Globals.initalize();
        baseFrame = new BaseFrame(Globals.settings.getDimension(100, 100));
        baseFrame.setVisible(true);
        initalized = true;
    }
    
    public static void MainMenu(){
        if (!initalized) initalize();
        if (baseFrame == null){
            initalize();
        }
        
        MainMenu.display();
    }
    
    public static void Game(){
        if (!initalized) initalize();
        GameVisual.initalize();
        gameStart = true;
    }
    
    public static void userInput(KeyEvent e) {
        if (!initalized) initalize();
        if (gameStart){
            GameVisual.userInput(e);
        }
    }
    
    public static void userInput(MouseEvent e) {
        if (!initalized) initalize();
        if (gameStart){
            GameVisual.userInput(e);
        }
    }
      
    public static void stop(){
        gameStart = false;
        baseFrame.dispose();
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
