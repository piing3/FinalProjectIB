package GameUI;

import Main.Globals;
import Main.Visual;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

/**
 *
 * @author d.holmberg
 */
public class PauseMenu extends JInternalFrame{

    private JButton btnExit;
    private JButton btnClose;
    
    public PauseMenu() {
        this.setLocation(Globals.settings.getPoint(45,20));
        System.out.println(this.getLocation());
        this.setSize(Globals.settings.getDimension(20, 60));
        System.out.println(this.getSize());
        this.setVisible(true);
        this.setResizable(false);
        this.setBorder(null);
        this.setBackground(Color.red);
        Visual.baseFrame.add(this);
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

/*Legacy code

class Menu extends JFrame{
    
    private JButton btnExit;//exit button
    private Container container;//the button container
    private JButton close;//close button
    
    public Menu(){
        container = this.getContentPane();// initalizes container
        this.setVisible(false);//make form visable
        Random r = new Random();
        this.getContentPane().setBackground(new Color(r.nextInt(254), r.nextInt(254), r.nextInt(254)));//set a random backround color
        this.setAlwaysOnTop(true);//make it infront of other form
        this.setLayout(null);
        this.setTitle("Menu");
        this.setUndecorated(true);//remove borders and top bar
        this.setResizable(false);//lock it in place
        this.setBounds(500, 25, 300, 600);
        
        btnExit = new JButton("Exit");//make the exit button 
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.white);
        btnExit.setSize(100, 50);
        btnExit.setLocation(100, 100);
        container.add(btnExit); 
        
        
        close = new JButton("Close");//make the close button
        close.setSize(100, 50);
        close.setLocation(100, 500);
        close.setBackground(Color.gray);
        close.setForeground(Color.black);
        container.add(close);
        
        ActionListener exit = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };//exit event and add
        btnExit.addActionListener(exit);
        
        ActionListener closeMenu = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Visual.menu.setVisible(false);
                Visual.menuOpen = false;
            }
        };//close event and add
        close.addActionListener(closeMenu);
    }
}

*/