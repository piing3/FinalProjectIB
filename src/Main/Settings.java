package Main;

import Utill.FileHandler;
import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author d.holmberg
 */
public class Settings implements Serializable{

    public static String fileName = "src\\Resources\\Settings.txt";
    private static FileHandler<Settings> fileHandler = new FileHandler<Settings>();
    
    public int width;
    public int height;
    public int mapWidth;
    public int mapHeight;
    public String gQuality = "sh*t";// for "expandibility"
    
    public Settings() {
        width = height = 0;
    }
    
    public static void readFile() {
        writeFile();
        Globals.settings = fileHandler.openObject(fileName);
    }
    
    public static void writeFile(){
       
        Globals.settings = new Settings();
        
        Globals.settings.width = 1440;
        Globals.settings.height = 900;
        
        fileHandler.saveObject(Globals.settings, fileName);
    }
    
    public Point getPoint(double x, double y) {
        return new Point((int)(width*(x/100)), (int)(height*(y/100)));
    }

    public Dimension getDimension(double x, double y) {
        return new Dimension((int)(width*(x/100)), (int)(height*(y/100)));
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
