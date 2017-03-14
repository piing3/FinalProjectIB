package Main;

/**
 *
 * @author d.holmberg
 */
public class Main {

    
    public static void main(String[] args) {
        Visual.MainMenu();
    }
    
    public static void exit() {
        System.out.println("Program ending");
        Visual.stop();
        Globals.stop();
        System.out.println("Program ended normaly");       
    }

    //----Variables-----------

}
