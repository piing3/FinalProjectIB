package GameLogic;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Main.Globals;

/**
 * 
 * @author d.holmberg
 */
public class Turn {

    private static int maxSize = 4;
    private static int turn = 0;

    /**
     * Add a new player to the game
     * @param newPlayer 
     */
    public void addPlayer(Player newPlayer){
        if (Globals.players.size() < maxSize) {
            Globals.players.add(newPlayer);
            return;
        }
        JOptionPane.showMessageDialog(null, "Can not add anymore players.");
        return;
    }
    
    /**
     * Change to the next turn
     */
    public static void NextTurn(){
        turn++;
        if(turn == maxSize) turn -= maxSize;
        Globals.players.get(turn).startTurn();
    }


    //----Variables-----------


    public static int getTurn() {
        return turn;
    }
    public static void setTurn(int turn) {
        Turn.turn = turn;
    }

    
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
