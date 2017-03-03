package Main;

import Utill.FileHandler;
import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author d.holmberg
 */
class Settings implements Serializable{

    static private String fileName = "src\\Resources\\Settings.txt";
    static FileHandler<Settings> fileHandler = new FileHandler<Settings>();
    
    public int width;
    public int hight;
    
    public Settings() {
        width = hight = 0;
    }
    
    public static void readFile() {
        Globals.settings = fileHandler.openObject(fileName);
    }
    
    public Point getPoint(int x, int y) {
        return new Point(width*(x/100), hight*(y/100));
    }

    public Dimension getDimension(int x, int y) {
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
