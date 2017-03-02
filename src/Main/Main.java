package Main;

import Main.Globals;
import javax.swing.JDesktopPane;

/**
 *
 * @author d.holmberg
 */
public class Main {

    
    public static void main(String[] args) {
        //Globals.initalize();
        //MainMenu.display();
        JDesktopPane jdp = new JDesktopPane();
        jdp.setSize(1000, 1000);
        jdp.setVisible(true);
        
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
