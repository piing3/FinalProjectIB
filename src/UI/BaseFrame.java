package UI;

import Main.Globals;
import javax.swing.JDesktopPane;

/**
 *
 * @author d.holmberg
 */
public class BaseFrame extends JDesktopPane{

    public BaseFrame() {
        
        this.setLocation(0, 0);
        this.setSize(1000, 1000);
        this.setVisible(true);
    
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
