package UI;

import Main.Globals;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

/**
 *
 * @author d.holmberg
 */
public class PauseMenu extends JInternalFrame{

    private JButton btnExit;
    private JButton btnClose;
    
    public PauseMenu() {
        this.setLocation(Globals.settings.getPoint(45,20));
        this.setSize(Globals.settings.getDimension(20, 60));
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(Color.red);
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
