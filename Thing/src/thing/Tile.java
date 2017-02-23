/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thing;

import java.awt.Color;
import java.awt.Container;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Deborah
 */
class Tile extends JPanel{

    JLabel Base = new JLabel();
    int BaseType = -1;
    public Tile(int X, int Y, Container frame) {
        this.setLocation(X*50, Y*50);
        this.setSize(50, 50);
        this.setLayout(null);
        frame.add(this);
        
        Base.setSize(50, 50);
        Base.setLocation(0, 0);
        this.add(Base, 0);
        
    }
    
    public void setBase(int number){
        BaseType = number;
        if(number == 0) Base.setIcon(new ImageIcon("src\\Images\\GrassTile1.png"));
        if(number == 1) Base.setIcon(new ImageIcon("src\\Images\\DessertTile1.png"));
        if(number == 2) Base.setIcon(new ImageIcon("src\\Images\\WaterTile1.png"));
        if(number == 3) Base.setIcon(new ImageIcon("src\\Images\\GrassTile1.png"));
    }
    
}
