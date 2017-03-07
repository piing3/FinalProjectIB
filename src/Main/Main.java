package Main;

import Main.Globals;
import GameUI.PauseMenu;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author d.holmberg
 */
public class Main {

    
    public static void main(String[] args) {
        Globals.initalize();//Globals need to come before visuals
        Visual.initalize();
        PauseMenu menu = new PauseMenu();
        //MainMenu.display();
        
        
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
