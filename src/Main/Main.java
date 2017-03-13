package Main;

/**
 *
 * @author d.holmberg
 */
public class Main {

    
    public static void main(String[] args) {
        Globals.initalize();
        Visual.initalize();
        Visual.MainMenu();
        
        
    }
    
    public static void exit() {
        System.out.println("Program ending");
        Visual.stop();
        Globals.stop();
        System.out.println("Program ended normaly");       
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
