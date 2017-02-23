package Logic;

import java.util.ArrayList;

/**
 * 
 * @author d.holmberg
 */
public class Turn {

    private int maxSize = 4;
    private int turn = 0;
    private Player[] players = new Player[maxSize];

    public void addPlayer(Player newPlayer){
        for (int i = 0; i < maxSize; i++) {
            if(players[i] == null) players[i] = newPlayer;
        }
    }


    //----Variables-----------

    public Player[] getPlayers() {
        return players;
    }

    public int getTurn() {
        return turn;
    }
    public void setTurn(int turn) {
        this.turn = turn;
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
