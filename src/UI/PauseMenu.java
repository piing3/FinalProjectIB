package UI;

import Main.Globals;
import javax.swing.JInternalFrame;

/**
 *
 * @author d.holmberg
 */
public class PauseMenu extends JInternalFrame{

    public PauseMenu() {
        this.setLocation(0, 0);
        this.setSize(100, 100);
        this.setVisible(true);
        
        Globals.baseFrame.add(this);
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
