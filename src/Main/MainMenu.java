package Main;

import Utill.Globals;
import GameLogic.Player;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Handles all the operations of the main menu
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
                addPlayers();
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
    
    public static void addPlayers() {
        if(!World.Map.initalized) World.Map.initalize();
        String[] options = new String[4];
        options[0] = 1+"";
        options[1] = 2+"";
        options[2] = 3+"";
        options[3] = 4+"";
        String playersTemp = (String) JOptionPane.showInputDialog(baseFrame, "How many players?", null, JOptionPane.PLAIN_MESSAGE, null, options, 2);
        int players = Integer.parseInt(playersTemp);
        GameLogic.Turn.setMaxSize(players);
        for (int i = 0; i < players; i++) {
            String name = JOptionPane.showInputDialog(baseFrame, "Enter a name for player #"+(i+1));
            GameLogic.Player p = new Player(name);
            p.spawn(i);
            Globals.playerList.add(p);
        }
        
        World.MapUtil.setFocus(Globals.playerList.get(0));
        GameVisual.UserInt.updateTurn();
    }

    //----Variables-----------

}
