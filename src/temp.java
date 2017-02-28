package UI;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author Davin
 * 
 * A container that will open when the "escape" key is pressed
 */
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
