package GameUI;

import Main.Visual;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author d.holmberg
 */
public class UserInput implements KeyListener, MouseListener{

    public UserInput() {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Visual.userInput(e);
        
        /* //map movement code
        if (e.getKeyCode() == 38){//up
            if (downOff != 0){
                downOff--;
            }
            redrawMap();
            LoadUnits();
        }
        if (e.getKeyCode() == 37){//left
            if (rightOff != 0){
                rightOff--;
            }
            redrawMap();
            LoadUnits();
        }
        if (e.getKeyCode() == 40){//down

            if (downOff != (72-Map.y)){
                downOff++;    
            }
            redrawMap();
            LoadUnits();
        }
        if (e.getKeyCode() == 39){//right

            if (rightOff != (128-Map.x)){
                rightOff++;    
            }
            redrawMap();
            LoadUnits();
        }
        */
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Visual.userInput(e);
        /*  //game interactions
        int tileX = (getMousePosition().x-25)/50+rightOff;//get mouse grid location
        int tileY = (getMousePosition().y-25)/50+downOff;
        int cityIndex = FindCity(tileX, tileY);//get city index at mouse
        int unitIndex = -1; 
        if (movingUnit == false && attackingUnit == false ){//not moving or attacking 

        unitIndex = UnitType.FindUnit(tileX, tileY);//get unit index at mouse
        if (unitIndex != -1 && cityIndex != -1) {//both unit and city
        if (CityUIOpen) {//if city open, open unit
            UserInt.UnitUI(FinalProject.units.get(unitIndex));
            moveEnabled = true;
            CityUIOpen = false;
            UnitUIOpen = true;
        }
        else if (UnitUIOpen) {//if unit open, open city
            UserInt.CityUI(FinalProject.cities.get(cityIndex));
            moveEnabled = false;
            CityUIOpen = true;
            UnitUIOpen = false;
        }
        else if (!UnitUIOpen && !CityUIOpen){// if neither open, open unit
            UserInt.UnitUI(FinalProject.units.get(unitIndex));
            moveEnabled = true;
            CityUIOpen = false;
            UnitUIOpen = true;
        }
    }
        else if (cityIndex != -1) {//if city, open city
            UserInt.CityUI(FinalProject.cities.get(cityIndex));
            moveEnabled = false;
            CityUIOpen = true;
            UnitUIOpen = false;
        }
        else if (unitIndex != -1) {//if unit, open unit
            UserInt.UnitUI(FinalProject.units.get(unitIndex));
            moveEnabled = true;
            CityUIOpen = false;
            UnitUIOpen = true;
        }
        if (cityIndex == -1 && unitIndex == -1) {//if neither, set normal UI
            UserInt.NormalUI(); 
            moveEnabled = true;
            CityUIOpen = false;
            UnitUIOpen = false;
        }
        */
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
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
