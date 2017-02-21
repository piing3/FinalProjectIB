package Logic;

import Utill.FileHandler;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author d.holmberg
 */
public class BuildIndex {

    private Production[] list;
    private String fileName = "";

    public BuildIndex() {
        
        FileHandler<Production[]> fileHandler = new FileHandler<Production[]>();
        list = fileHandler.openObject("");
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
