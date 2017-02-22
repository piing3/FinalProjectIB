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
    private String fileName = "src\\Resources\\BuildIndex.txt";
    private FileHandler<Production[]> fileHandler = new FileHandler<Production[]>();


    public BuildIndex() {
        list poop = fileHandler.openObject(fileName);
        System.out.println(poop.getName());
        //writeFile();
    }
    
    private void writeFile(){
       
        list = new Production[100];
        
        ImageIcon icon = new ImageIcon("src\\Resources\\WarriorIconMed.txt");
        list[0] = new MeleeUnit("Warrior", "Basic melee unit", 40, 100, icon, 20, 50, false);
        list[1] = new RangedUnit("Archer", "Basic ranged unit", 45, 120, icon, 10, 50, false);
        list[2] = new CivilUnit("Settler", "Can make a new city", 70, 250, icon, 0);
        list[3] = new CivilUnit("Worker", "Can build and repair tile improvements", 40, 100, icon, 0);
        
        Production poop = new Production("test", "", 0, 0, null);
        
        fileHandler.saveObject(list, fileName);
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
