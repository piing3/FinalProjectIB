package Main;

/**
 *
 * @author d.holmberg
 */
public class Main {

    
    public static void main(String[] args) {
        Globals.initalize();//Globals need to come before visuals
        Visual.initalize();
        Visual.MainMenu();
        
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
