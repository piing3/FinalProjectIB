package Main;

import GameLogic.CivilUnit;
import GameLogic.MeleeUnit;
import GameLogic.Production;
import GameLogic.RangedUnit;
import Utill.FileHandler;
import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author d.holmberg
 */
public class Settings implements Serializable{

    public static String fileName = "src\\Resources\\Settings.txt";
    private static FileHandler<Settings> fileHandler = new FileHandler<Settings>();
    
    public int width;
    public int hight;
    public String gQuality = "sh*t";// for "expandibility"
    
    public Settings() {
        width = hight = 0;
    }
    
    public static void readFile() {
        Globals.settings = fileHandler.openObject(fileName);
    }
    
    public static void writeFile(){
       
        Globals.settings = new Settings();
        
        Globals.settings.width = 1000;
        Globals.settings.hight = 1000;
        
        fileHandler.saveObject(Globals.settings, fileName);
    }
    
    public Point getPoint(int x, int y) {
        return new Point(width*(x/100), hight*(y/100));
    }

    public Dimension getDimension(int x, int y) {
        return new Dimension(width*(x/100), hight*(y/100));
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
