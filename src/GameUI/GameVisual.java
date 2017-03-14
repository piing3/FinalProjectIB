package GameUI;

import Main.Globals;
import Main.Visual;
import World.Map;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Sub-master class for game visuals 
 * @author d.holmberg
 */
public class GameVisual extends Visual{

    private static Container world;
    private static Container ui;
    
    public static void initalize() {
        
        world = new Container();
        world.setSize(Globals.settings.getDimension(100, 100));
        world.setLayout(null);
        
        ui = new Container();
        ui.setSize(Globals.settings.getDimension(100, 100));
        ui.setLayout(null);

        //UserInt.initalize();
        Map.initalize();
        
        Container c = new Container();
        c.add(world);
        c.add(ui);
        c.setBackground(Color.red);
        
        
        
        Visual.baseFrame.setContentPane(c);
        
    }

    /**
     * Enacts a key event
     * <b> Not Finished </b>
     * @param e The key event
     */
    public static void userInput(KeyEvent e) {
         if (e.getKeyCode() == 27){//escape, toggle menu
            /*
            if (menuOpen == false){
                menu.setVisible(true);
                menuOpen = true;
            }
            else if (menuOpen == true){
                menu.setVisible(false);
                menuOpen = false;
            }
            */
        }
        
        if (e.getKeyCode() == 81){//q, make city at mouse
            /*
            int cityX = (getMousePosition().x-25)/50+rightOff;
            int cityY = (getMousePosition().y-25)/50+downOff;
            int index = FindCity(cityX, cityY);
            if (index == -1)
            {
                FinalProject.cities.add(new City(cityX, cityY, TurnOrder.whoTurn()-1));
            } 
            */
        }
        
        if (e.getKeyCode() == 87){//w, make unit at mouse
            /*
            int unitX = (getMousePosition().x-25)/50+rightOff;
            int unitY = (getMousePosition().y-25)/50+downOff;
            int index = UnitType.FindUnit(unitX, unitY);
            if (index == -1)
            {
                int type = Integer.parseInt(JOptionPane.showInputDialog("Enter Unit Type"));
                UnitType.CreateUnit(unitX, unitY, type, Units);
            } 
            */
        }
        /*
        if(moveEnabled){//map movement
            
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
        }
        */
    }

    /**
     * Enacts a mouse event
     * <b> Not Finished</b>
     * @param e The mouse event
     */
    public static void userInput(MouseEvent e) {
        /*
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
        }
        if (movingUnit && attackingUnit == false){//if moving unit
            int unitX = UserInt.unit.x;
            int unitY = UserInt.unit.y;
            if (Globals.unitGrid[unitX][unitY] != 4){//ground
                UnitType.MoveGround(UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y), tileX, tileY);
                UserInt.updateMoves();
            }
            if (Globals.unitGrid[unitX][unitY] == 4){//water
                UnitType.MoveWater(UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y), tileX, tileY);
                UserInt.updateMoves();
            }
        }
        if (movingUnit == false && attackingUnit) {//if attacking
            int index1 = UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y);
            int index2 = UnitType.FindUnit(tileX, tileY);
            UnitType.Attack(index1, index2);
        }
        */
    }


    //----Variables-----------

    public static void worldAdd(Component comp) {
        world.add(comp,0);
    }
    public static void uiAdd(Component comp) {
        //ui.add(comp);
    }


    
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

/* Legacy Code

public class Visual extends JFrame implements KeyListener, MouseListener  {
    static Container tiles;//containers
    static Container Units;
    static Container UI;
    static Container CityUI;
    static Container ProdutionUI;
    static Container UnitUI;
    
    static public int width;// width and height of the form
    static public int hight;
    
    static boolean moveEnabled = true;//mouse click condions
    static boolean movingUnit = false;
    static boolean attackingUnit = false;
    
    static boolean UnitUIOpen = false;//UI open
    static boolean CityUIOpen = false;
    
    static Boolean menuOpen = false;//menu open
    static Menu menu = new Menu();
    
    static int downOff = 0, rightOff = 0;//Down and Right offsets, used for moving map.
    
    public Visual() throws FileNotFoundException {
        this.setSize(1256, 728); //make the display 
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        width = this.getWidth();//store width and height
        hight = this.getHeight();
        
        tiles = this.getContentPane();//make containers
        Units = this.getContentPane();
        UI = this.getContentPane();
        UnitUI = this.getContentPane();
        CityUI = this.getContentPane();
        ProdutionUI = this.getContentPane();  
        
        Visual.tiles.setLayout(null);//set layout
        
        this.addKeyListener(this);//add input listeners
        this.addMouseListener(this);
        
        UserInt userInt = new UserInt();//make user interface
        Map map = new Map();//make map
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27){//escape, toggle menu
            if (menuOpen == false){
                menu.setVisible(true);
                menuOpen = true;
            }
            else if (menuOpen == true){
                menu.setVisible(false);
                menuOpen = false;
            }    
        }
        
        if (e.getKeyCode() == 81){//q, make city at mouse
            int cityX = (getMousePosition().x-25)/50+rightOff;
            int cityY = (getMousePosition().y-25)/50+downOff;
            int index = FindCity(cityX, cityY);
            if (index == -1)
            {
                FinalProject.cities.add(new City(cityX, cityY, TurnOrder.whoTurn()-1));
            } 
            
        }
        
        if (e.getKeyCode() == 87){//w, make unit at mouse
            int unitX = (getMousePosition().x-25)/50+rightOff;
            int unitY = (getMousePosition().y-25)/50+downOff;
            int index = UnitType.FindUnit(unitX, unitY);
            if (index == -1)
            {
                int type = Integer.parseInt(JOptionPane.showInputDialog("Enter Unit Type"));
                UnitType.CreateUnit(unitX, unitY, type, Units);
            } 
            
        }
        if(moveEnabled){//map movement
            
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
        }
    }

    public static void redrawMap(){
        for (int i = 0; i < Map.x; i++){
                for (int j = 0; j < Map.y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + rightOff][j + downOff]);
                    Map.borderGrid[i][j].setBorder(Map.borderType[i + rightOff][j + downOff]);

                }
            }
    }
    public static void LoadUnits(){
        for (int i = 0; i <= 127; i++){
            for (int j = 0; j <= 71; j++){
                if (UnitType.FindUnit(i,j) > -1){
                    int index = UnitType.FindUnit(i,j);
                    Unit unit = FinalProject.units.get(index);
                    if (unit.x == i&& unit.y == j){
                        unit.setLocation((i- rightOff)*50, (j- downOff)*50);
                        unit.setUnit(Globals.unitGrid[i][j]);
                    }
                }
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
            
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
        }
        if (movingUnit && attackingUnit == false){//if moving unit
            int unitX = UserInt.unit.x;
            int unitY = UserInt.unit.y;
            if (Globals.unitGrid[unitX][unitY] != 4){//ground
                UnitType.MoveGround(UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y), tileX, tileY);
                UserInt.updateMoves();
            }
            if (Globals.unitGrid[unitX][unitY] == 4){//water
                UnitType.MoveWater(UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y), tileX, tileY);
                UserInt.updateMoves();
            }
        }
        if (movingUnit == false && attackingUnit) {//if attacking
            int index1 = UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y);
            int index2 = UnitType.FindUnit(tileX, tileY);
            UnitType.Attack(index1, index2);
        }
    }
    public static int FindCity(int x, int y){
        int result = -1;
        for (int i = 0; i < FinalProject.cities.size(); i++) {
            City city = FinalProject.cities.get(i);
            if (city.x == x && city.y == y){
                result = i;
            }
        }
        return result;
    } 

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Container getUnits() {
        return Units;
    }

    public static int getRightOff() {
        return rightOff;
    }

    public static int getDownOff() {
        return downOff;
    }

    public static Container getTiles() {
        return tiles;
    }

    public static void setTiles(Container tiles) {
        Visual.tiles = tiles;
    }

    
    
    
    
   
    
}
*/