/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Davin
 * 
 * Currently used for city borders but could be used for other, unimplemented borders 
 */
class Border extends JLabel{

    
        public int x;//XY of the border
        public int y;
        public int borderType;//Type of border
        
        public Border(int x, int y) {
            this.x = x; this.y = y;//stores grid location
            this.setSize(50, 50);//set bounds
            this.setLocation((x * 50), (y * 50));
        }
   /**
    * Used to set the tile to the given type(color)
    * 
    * @param type: The number used to set the border image
    */
   public void setBorder(int type){
       if (type == 0){ //clear icon for this border  
           this.setIcon(null);
       }
       if (type == 1){//pink
           Icon icon = new ImageIcon("src\\Images\\PinkBorder.png");
           this.setIcon(icon);
       }
       if (type == 2){//red
           Icon icon = new ImageIcon("src\\Images\\RedBorder.png");
           this.setIcon(icon);
       }
       if (type == 3){//green
           Icon icon = new ImageIcon("src\\Images\\GreenBorder.png");
           this.setIcon(icon);
       }
       if (type == 4){//blue
           Icon icon = new ImageIcon("src\\Images\\BlueBorder.png");
           this.setIcon(icon);
       }
   } 
}
