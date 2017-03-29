package Utill;

import Main.Visual;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author d.holmberg
 */
public class UserInput implements KeyListener, MouseListener{

    @Override
    public void keyPressed(KeyEvent e) {
        Visual.userInput(e);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Visual.userInput(e);
    }
    
    @Override
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
