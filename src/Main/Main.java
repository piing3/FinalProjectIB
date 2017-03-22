package Main;

/**
 *
 * @author d.holmberg
 */
public abstract class Main {

    
    public static void main(String[] args) {
        System.out.println("Program starting");
        Visual.MainMenu();
        System.out.println("Program started normaly");
    }
    
    public static void exit() {
        System.out.println("Program ending");
        Visual.stop();
        Globals.stop();
        System.out.println("Program ended normaly");       
    }

    //----Variables-----------

}
