package GameUI;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author d.holmberg
 */
public class BaseFrame extends JFrame{

    public BaseFrame() {
        this(new Dimension(0, 0));
    }

    public BaseFrame(Dimension dimension) {
        
        this.setSize(dimension);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    
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
