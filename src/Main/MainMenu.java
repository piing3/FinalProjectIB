package Main;

import GameUI.PauseMenu;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Handles all the operations of the main menu, static 
 * @author d.holmberg
 */
public abstract class MainMenu extends Visual{

    private static Container container;
    
    public static void display(){
        Container container = new Container();
        container.setSize(Globals.settings.getDimension(100, 100));
        container.setLayout(null);
        
        JButton btnStart = new JButton("Start");
        btnStart.setSize(Globals.settings.getDimension(20, 10));
        btnStart.setLocation(Globals.settings.getPoint(40, 35));
        btnStart.setFocusable(false);
        ActionListener start = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visual.Game();
            }
        };
        btnStart.addActionListener(start);
        container.add(btnStart);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setSize(Globals.settings.getDimension(20, 10));
        btnExit.setLocation(Globals.settings.getPoint(40, 65));
        btnExit.setFocusable(false);
        ActionListener exit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.exit();
            }
        };
        btnExit.addActionListener(exit);
        container.add(btnExit);
        
        baseFrame.setContentPane(container);
    }
    
    
    
    /*Legacy code
        public static int play;
         
        play = 2;//Integer.parseInt(JOptionPane.showInputDialog("How many people are playing"));//gets the number of players, locked at 2 tempariliy
        TurnOrder turnorder = new TurnOrder();
        if (play < 2)JOptionPane.showMessageDialog(null, "you cant play alone.");//Check vailid input
        else if (play > 4) JOptionPane.showMessageDialog(null, "You can only have up to 4 players");
        else {
        for (int i = 0; i < play; i++) {//makes players
            String name = JOptionPane.showInputDialog("What is your name?");
                 if(i == 0) FinalProject.Players.add(new Player(name, i+1));
            else if(i == 1) FinalProject.Players.add(new Player(name, i+1));
            else if(i == 2) FinalProject.Players.add(new Player(name, i+1));
            else if(i == 3) FinalProject.Players.add(new Player(name, i+1));
        }
        FinalProject.Players.get(0).isTurn = true;//begin turns
       Visual visual = new Visual() {
        
            @Override//extra key events here to make Visual neater
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };        
        TurnOrder.spawnStart();//spawn player one
        visual.setVisible(true);//make display visable
        }
    */


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
