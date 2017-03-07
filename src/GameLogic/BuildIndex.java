package GameLogic;

import Main.Globals;
import Utill.FileHandler;
import javax.swing.ImageIcon;

/**
 *
 * @author d.holmberg
 */
public class BuildIndex {

    private static String fileName = "src\\Resources\\BuildIndex.txt";
    private static FileHandler<Production[]> fileHandler = new FileHandler<Production[]>();


    public static void readFile() {
        //writeFile();
        Globals.buildList = fileHandler.openObject(fileName);
    }
    
    private static void writeFile(){
       
        Globals.buildList = new Production[100];
        
        ImageIcon icon = new ImageIcon("src\\Resources\\WarriorIconMed.png");
        Globals.buildList[0] = new MeleeUnit("Warrior", "Basic melee unit", 40, 100, icon, 20, 50, false);
        Globals.buildList[1] = new RangedUnit("Archer", "Basic ranged unit", 45, 120, icon, 10, 50, false);
        Globals.buildList[2] = new CivilUnit("Settler", "Can make a new city", 70, 250, icon, 0);
        Globals.buildList[3] = new CivilUnit("Worker", "Can build and repair tile improvements", 40, 100, icon, 0);
        
        fileHandler.saveObject(Globals.buildList, fileName);
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
