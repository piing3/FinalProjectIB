package GameVisual;

import GameLogic.City;
import GameLogic.Combat;
import GameLogic.Unit;
import Utill.Globals;
import Main.Visual;
import World.Map;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Sub-master class for game visuals 
 * @author d.holmberg
 */
public abstract class GameVisual extends Visual{

    private static Container world;
    private static Container ui;
    
    public static void initalize() {
        
        world = new Container();
        world.setSize(Globals.settings.getDimension(100, 100));
        world.setLayout(null);
        
        ui = new Container();
        ui.setSize(Globals.settings.getDimension(100, 100));
        ui.setLayout(null);

        
        Map.initalize();
        UserInt.initalize();
        
        Container c = new Container();
        c.setSize(Globals.settings.getDimension(100, 100));
        c.setLayout(null);
        c.add(world);
        c.add(ui,0);
        
        Visual.baseFrame.setContentPane(c);
        Visual.baseFrame.repaint();
        
    }

    /**
     * Enacts a key event
     * <b> Not Finished </b>
     * @param e The key event
     */
    public static void userInput(KeyEvent e) {
        if (e.getKeyCode() == 27){//escape, toggle menu
            
        }
        if (e.getKeyCode() == 38){//up
            if (Map.getDownOff() != 0){
                Map.changeDownOff(-1);
            }
        }
        if (e.getKeyCode() == 37){//left
            Map.changeRightOff(-1);
        }
        if (e.getKeyCode() == 40){//down

            if (Map.getDownOff() != (Map.MAP_HEIGHT-Map.getDisplayHeight())){//
                Map.changeDownOff(1);    
            }
        }
        if (e.getKeyCode() == 39){//right
            Map.changeRightOff(1);
        }

        if(Map.getRightOff() == -1) Map.setRightOff(Map.MAP_WIDTH-1);
        if(Map.getRightOff() == Map.MAP_WIDTH) Map.setRightOff(0);

        Map.redrawMap();
        Map.redrawUnits();
    }

    /**
     * Enacts a mouse event
     * <b> Not Finished</b>
     * @param e The mouse event
     */
    public static void userInput(MouseEvent e) {
        
        Point mouse = e.getPoint();
        int tileX = (int)(mouse.x/Tile.SIZE)+Map.getRightOff();
        int tileY = (int)((mouse.y-22)/Tile.SIZE)+Map.getDownOff();
        
        int unitIndex = Unit.findUnit(tileX, tileY);
        int cityIndex = City.findCity(tileX, tileY);
        
        if(UserInt.isMovingUnit()){
            if(Unit.getSelectedUnit() == null) return;
            int selectedIndex = Unit.findUnit(Unit.getSelectedUnit().getPos().x, Unit.getSelectedUnit().getPos().y);
            Unit.MoveGround(selectedIndex, tileX, tileY);
        }
        
        else if(UserInt.isAttackingUnit()){
            
            int range = Map.range(Unit.getSelectedUnit().getPos(), new Point(tileX, tileY));
            int damage, defence;
            
            if(range == 1 && Unit.getSelectedUnit().getMDamage() != 0){
                Combat.unitMelee(Unit.getSelectedUnit(), Globals.unitList.get(unitIndex));
            }
            else if(range >= 1 && Unit.getSelectedUnit().getRDamage() != 0 && range <= Unit.getSelectedUnit().getRange()){
                Combat.unitRanged(Unit.getSelectedUnit(), Globals.unitList.get(unitIndex));
            }
            
        }
        
        else if (unitIndex != -1) {
            UserInt.showUI(Globals.unitList.get(unitIndex));
        }
        
        else if (cityIndex != -1) {
            UserInt.showUI(Globals.cityList.get(cityIndex));
        }
        else{
            UserInt.showUI();
        }
    }

    public static void addUnit(int x, int y, int type, int player){
        Unit unit = new Unit(type, x, y, player);
        Globals.unitList.add(unit);
    }  
    
    public static void addCity(int x, int y, int player){
        City city = new City(x, y, player);
        Globals.cityList.add(city);
    }
    
    //----Variables-----------

    public static void worldAdd(Component comp) {
        world.add(comp,0);
    }
    public static void uiAdd(Component comp) {
        ui.add(comp,0);
    }
}