package GameUI;

import GameLogic.City;
import GameLogic.Player;
import GameLogic.Production;
import GameLogic.Turn;
import GameLogic.Unit;
import Main.Globals;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *to clean
 *handles all user interface mechanics
 * @author Davin
 */
public abstract class UserInt {
    
    private static JButton nextTurn;//normal ui components
    private static JLabel playerTurn;
        
    private static GameLogic.City city;
    private static GameLogic.Unit unit; 
    private static JLabel cityLeft;
    private static JLabel cityGold;
    private static JLabel cityFood;
    private static JLabel cityScience;
    private static JLabel cityProduction;
    private static JLabel cityName; 
    private static JPanel productionBackrounds = new JPanel();
    private static JScrollPane jsp = new JScrollPane();
    private static JPanel selectedProduction = new JPanel(null);
    private static GameLogic.Production selectedProductionItem;
    private static JLabel selectedIcon;
    private static JLabel selectedTitle;
    private static JLabel selectedCost;
    private static JLabel selectedDicription;
        
    private static JLabel unitBack;//unit ui components 
    private static JLabel unitHealth; 
    private static JLabel unitMoves; 
    private static JLabel unitName; 
    private static JButton unitMove;
    private static JButton unitSettle;
    private static JButton unitAttack;

    private static ArrayList<JPanel> productionPanelList = new ArrayList<JPanel>();//production lists
    private static ArrayList<JButton> productionButtonList = new ArrayList<JButton>();
        
    private static boolean movingUnit = false;
    private static boolean attackingUnit = false;
    
    public static void initalize(){
        
        makeBaseUI();
        MakeCityUI();//make the city ui
        MakeUnitUI();//make the unit ui
    }
    
    /**
     * closes city and unit UI
     */
    public static void showUI(){        
        visibleCityUI(false);
        visibleUnitUI(false);
        
    }
    
    /**
     * open the unit UI of the given unit
     * @param newUnit: the unit to open 
     */
    public static void showUI(GameLogic.Unit newUnit){   
        unit = newUnit;
        
        visibleCityUI(false);        
        visibleUnitUI(true);
        
        unitName.setText(unit.getName()+"");
        unitHealth.setText("Health: "+unit.getHealth());
        unitMoves.setText("Moves:  "+unit.getMovementCur());
    }
    
    /**
     * opens the city UI of the given city
     * @param newCity: the city to open
     */
    public static void showUI(GameLogic.City newCity){ 
        if(newCity == null) return;       
        city = newCity;
        
        updateProductionList();
        updateProductionItem();
        
        visibleCityUI(true);
        visibleUnitUI(false);
        
        cityFood.setText("Food: "+city.getFood());
        cityGold.setText("Gold: "+city.getGold());
        cityProduction.setText("Production: "+city.getProduction());
        cityScience.setText("Science: "+city.getProduction());
        cityName.setText(city.getName()+" ("+city.getPopulation()+")");
        
    }
    
    /**
     * Makes the constant UI elements
     */
    private static void makeBaseUI(){
        JPanel UIBackround = new JPanel();//make UIBackround
        UIBackround.setLocation(getPoint(80, 80));
        UIBackround.setSize(getDimension(20, 20));
        UIBackround.setBackground(Color.GRAY);
        GameVisual.uiAdd(UIBackround);
        
        playerTurn = new JLabel();//make playerTurn label 
        playerTurn.setSize(getDimension(20, 5));
        playerTurn.setLocation(getPoint(80, 80));
        playerTurn.setHorizontalAlignment(SwingConstants.CENTER);
        playerTurn.setForeground(Color.BLACK);
        GameVisual.uiAdd(playerTurn);
        
        nextTurn = new JButton("Next Turn");//make nextTurn button
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showUI();
                GameLogic.Turn.NextTurn();
                updateTurn();
            }
        };
        nextTurn.addActionListener(actionListener);
        nextTurn.setSize(getDimension(20, 15)); 
        nextTurn.setLocation(getPoint(80, 85));
        nextTurn.setBackground(Color.orange);
        nextTurn.setForeground(Color.black);
        nextTurn.setFocusable(false);
        GameVisual.uiAdd(nextTurn);
        
    }
    
    /**
     * makes all the unit UI elements
     */
    private static void MakeUnitUI(){
        Icon unitBackround = new ImageIcon("src\\Resources\\UnitBackroundSmall.png");
        unitBack = new JLabel(unitBackround);
        unitBack.setSize(getDimension(39, 20));
        unitBack.setLocation(getPoint(0, 80));
        unitBack.setVisible(false);
        unitBack.setFocusable(false);
        GameVisual.uiAdd(unitBack);
                
        unitName = new JLabel();
        unitName.setSize(getDimension(15, 5));
        unitName.setLocation(getPoint(24, 81));
        unitName.setVisible(false);
        unitName.setFocusable(false);
        unitName.setFont(new Font(null, Font.PLAIN, 30));
        GameVisual.uiAdd(unitName);
        
        unitHealth = new JLabel();
        unitHealth.setSize(getDimension(15, 5));
        unitHealth.setLocation(getPoint(24, 87));
        unitHealth.setVisible(false);
        unitHealth.setFocusable(false);
        unitHealth.setFont(new Font(null, Font.PLAIN, 25));
        GameVisual.uiAdd(unitHealth);
        
        unitMoves = new JLabel();
        unitMoves.setSize(100, 20);
        unitMoves.setSize(getDimension(15, 5));
        unitMoves.setLocation(getPoint(24, 92));
        unitMoves.setVisible(false);
        unitMoves.setFocusable(false);
        unitMoves.setFont(new Font(null, Font.PLAIN, 25));
        GameVisual.uiAdd(unitMoves);

        
        Icon imgMove = new ImageIcon("src\\Resources\\unitMove.png");
        unitMove = new JButton(imgMove);
        ActionListener move = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setMovingUnit(!movingUnit);
            }
        };
        unitMove.addActionListener(move);
        unitMove.setSize(getDimension(4, 6));
        unitMove.setLocation(getPoint(0, 73));
        unitMove.setVisible(false);
        unitMove.setFocusable(false);
        GameVisual.uiAdd(unitMove);
           
        Icon imgSettle = new ImageIcon("src\\Resources\\unitSettle.png");
        unitSettle = new JButton(imgSettle);
        ActionListener settle = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = City.findCity(unit.getPos().x, unit.getPos().y);
                if (index == -1)
                {
                    int x = unit.getPos().x;
                    int y = unit.getPos().y;
                    GameVisual.addCity(x, y, Turn.getTurn());
                    int unitIndex = unit.findUnit(x, y);
                    Globals.unitList.remove(unit);
                    unit.kill();
                    showUI(Globals.cityList.get(City.findCity(x, y)));
                }  
            }
        };
        unitSettle.addActionListener(settle);
        unitSettle.setSize(getDimension(4, 6));
        unitSettle.setLocation(getPoint(0, 66));
        unitSettle.setVisible(false);
        unitSettle.setFocusable(false);
        GameVisual.uiAdd(unitSettle);
           
        Icon imgAttack = new ImageIcon("src\\Resources\\unitAttack.png");
        unitAttack = new JButton(imgAttack);
        ActionListener attack = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (!attackingUnit){
                    attackingUnit = true; 
                    unitAttack.setIcon(new ImageIcon("src\\Resources\\unitAttackSelected.png"));
                }
                else {
                    attackingUnit = false; 
                    unitAttack.setIcon(new ImageIcon("src\\Resources\\unitAttack.png"));
                } 
                
            }
        };
        unitAttack.addActionListener(attack);
        unitAttack.setSize(getDimension(4, 6));
        unitAttack.setLocation(getPoint(0, 66));
        unitAttack.setVisible(false);
        unitAttack.setFocusable(false);
        GameVisual.uiAdd(unitAttack);
    }
    
    /**
     * creates all the city UI elements
     */
    private static void MakeCityUI(){
        
        Icon leftBack = new ImageIcon("src\\Resources\\CityLeft.png");
        cityLeft = new JLabel(leftBack);
        cityLeft.setSize(getDimension(25, 76));
        cityLeft.setLocation(getPoint(0, 0));
        cityLeft.setVisible(false);
        cityLeft.setFocusable(false);
        GameVisual.uiAdd(cityLeft);
                
        cityGold = new JLabel();
        cityGold.setSize(getDimension(10, 3));
        cityGold.setLocation(getPoint(10, 10));
        cityGold.setFont(new Font(null, Font.PLAIN, 20));
        cityGold.setForeground(Color.yellow);
        cityGold.setVisible(false);
        cityGold.setFocusable(false);
        GameVisual.uiAdd(cityGold);
        
        cityFood = new JLabel();
        cityFood.setSize(getDimension(10, 3));
        cityFood.setLocation(getPoint(10, 14));
        cityFood.setFont(new Font(null, Font.PLAIN, 20));
        cityFood.setForeground(Color.green);
        cityFood.setVisible(false);
        cityFood.setFocusable(false);
        GameVisual.uiAdd(cityFood);
        
        cityProduction = new JLabel();
        cityProduction.setSize(getDimension(10, 3));
        cityProduction.setLocation(getPoint(10, 18));
        cityProduction.setFont(new Font(null, Font.PLAIN, 20));
        cityProduction.setForeground(Color.orange);
        cityProduction.setVisible(false);
        cityProduction.setFocusable(false);
        GameVisual.uiAdd(cityProduction);
        
        cityScience = new JLabel();
        cityScience.setSize(getDimension(10, 3));
        cityScience.setLocation(getPoint(10, 22));
        cityScience.setFont(new Font(null, Font.PLAIN, 20));
        cityScience.setForeground(Color.blue);
        cityScience.setVisible(false);
        cityScience.setFocusable(false);
        GameVisual.uiAdd(cityScience);

        cityName = new JLabel();
        cityName.setSize(getDimension(27, 5));
        cityName.setLocation(getPoint(0, 2));
        cityName.setFont(new Font(null, Font.PLAIN, 40));
        cityName.setForeground(Color.BLACK);
        cityName.setVisible(false);
        cityName.setFocusable(false);
        cityName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameVisual.uiAdd(cityName);
        
        MakeProductionUI();
    }
    
    /**
     * makes all the production UI elements(part of city UI)
     */
    public static void MakeProductionUI() {
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setSize(getDimension(24, 39));
        jsp.setLocation(getPoint(0, 26));
        jsp.setViewportView(productionBackrounds);
        GameVisual.uiAdd(jsp);
        jsp.setVisible(false);
        productionBackrounds.setBackground(Color.BLACK);
        productionBackrounds.setLayout(new BoxLayout(productionBackrounds, BoxLayout.Y_AXIS));
        
        selectedProduction.setLayout(null);
        selectedProduction.setBackground(Color.GRAY);
        selectedProduction.setSize(getDimension(24, 17));
        selectedProduction.setLocation(getPoint(0, 62));
        selectedProduction.setVisible(false);
        GameVisual.uiAdd(selectedProduction);
        
        Icon backroundImage = new ImageIcon("src\\Resources\\ProductionBackSmall.png");
        JLabel selectedBackround = new JLabel(backroundImage);
        selectedBackround.setSize(385, 150);
        selectedBackround.setLocation(0, 0);
        selectedProduction.add(selectedBackround, 0);
        
        selectedTitle = new JLabel();
        selectedTitle.setSize(200, 30);
        selectedTitle.setLocation(220, 15);
        selectedTitle.setFont(new Font(null, Font.PLAIN, 30));
        selectedTitle.setForeground(Color.BLACK);
        selectedProduction.add(selectedTitle, 0);

        selectedCost = new JLabel();
        selectedCost.setSize(190, 20);
        selectedCost.setLocation(155, 60);
        selectedCost.setFont(new Font(null, Font.PLAIN, 20));
        selectedCost.setForeground(Color.BLACK);
        selectedProduction.add(selectedCost, 0);

        selectedDicription = new JLabel();
        selectedDicription.setSize(150, 50);
        selectedDicription.setLocation(155, 80);
        selectedDicription.setFont(new Font(null, Font.PLAIN, 15));
        selectedDicription.setForeground(Color.BLACK);
        selectedProduction.add(selectedDicription, 0);
        
        selectedIcon = new JLabel();
        selectedIcon.setSize(150, 150);
        selectedIcon.setLocation(20, 0);
        selectedProduction.add(selectedIcon, 0);
        
    }
    
    /**
     * sets all the city UI elements to the given visibility 
     * @param visable:the given visibility 
     */
    private static void visibleCityUI(boolean visible){
        cityLeft.setVisible(visible);
        cityFood.setVisible(visible);
        cityGold.setVisible(visible);
        cityProduction.setVisible(visible);
        cityScience.setVisible(visible);
        cityName.setVisible(visible);
        jsp.setVisible(visible);
        if(selectedProductionItem != null)selectedProduction.setVisible(visible);
        else selectedProduction.setVisible(false);
    }
    
    /**
     * sets all the unit UI elements to the given visibility 
     * @param visable:the given visibility 
     */
    private static void visibleUnitUI(boolean visible){
        unitBack.setVisible(visible);
        unitHealth.setVisible(visible);
        unitMoves.setVisible(visible);
        unitName.setVisible(visible);
        unitMove.setVisible(visible);
        if (unit != null) {
            if(unit.canSettle()) {
                unitSettle.setVisible(visible);
                unitAttack.setVisible(false);
            }
            else{
                unitAttack.setVisible(visible);
                unitSettle.setVisible(false);
            }
        }
        
    }
    /**
     * updates the city UI's list of build objects
     */
    public static void updateProductionList(){
        productionPanelList.clear();
        productionBackrounds.removeAll();
        Player p = Globals.playerList.get(Turn.getTurn());
        for (int i = 0; i < p.getBuildList().size(); i++) {
            JPanel productionInfo = new JPanel();
            productionInfo.setLayout(null);
            productionInfo.setBackground(Color.BLACK);
            productionInfo.setPreferredSize(new Dimension(384, 160));
            productionBackrounds.add(productionInfo);
            productionPanelList.add(productionInfo);
            
            Icon backroundImage = new ImageIcon("src\\Resources\\ProductionBackSmall.png");
            JLabel backround = new JLabel(backroundImage);
            backround.setSize(385, 150);
            backround.setLocation(0, 0);
            productionInfo.add(backround, 0);
            
            Production thing = Globals.buildList[p.getBuildList().get(i)];
            
            JLabel title = new JLabel(thing.getName());
            title.setSize(200, 30);
            title.setLocation(220, 15);
            title.setFont(new Font(null, Font.PLAIN, 30));
            title.setForeground(Color.BLACK);
            productionInfo.add(title, 0);
            
            JLabel cost = new JLabel("Production cost: "+thing.getBuildCost());
            cost.setSize(190, 20);
            cost.setLocation(155, 60);
            cost.setFont(new Font(null, Font.PLAIN, 20));
            cost.setForeground(Color.BLACK);
            productionInfo.add(cost, 0);
            
            JLabel dicription = new JLabel(thing.getDiscription());
            dicription.setSize(150, 50);
            dicription.setLocation(155, 80);
            dicription.setFont(new Font(null, Font.PLAIN, 15));
            dicription.setForeground(Color.BLACK);
            productionInfo.add(dicription, 0);
            
            JButton select = new JButton("Select");
            select.setSize(100, 25);
            select.setLocation(200, 120);
            select.setForeground(Color.BLACK);
            select.setBackground(Color.GRAY);
            select.setFocusable(false);
            productionInfo.add(select, 0);
            final int index = i;
            ActionListener setProduction = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Player p = Globals.playerList.get(Turn.getTurn());
                    city.setProductionItem(Globals.buildList[p.getBuildList().get(index)]);
                    updateProductionItem();
                    
                }
            };
            select.addActionListener(setProduction);
        }
    }
    
    private static void updateProductionItem(){
        selectedProductionItem = city.getProductionItem();
        
        int one = city.getProductionRemain()/city.getProduction();
        double oneRaw = city.getProductionRemain()/city.getProduction();
        if (oneRaw > one) one++; 
        
        if (selectedProductionItem != null) {
            int two = selectedProductionItem.getBuildCost()/city.getProduction();
            double twoRaw = selectedProductionItem.getBuildCost()/city.getProduction();
            if (twoRaw > two) two++; 

            selectedCost.setText("Production left: "+one+" / "+two);
            selectedTitle.setText(selectedProductionItem.getName()+"");
            selectedDicription.setText(selectedProductionItem.getDiscription()+"");
            selectedIcon.setIcon(selectedProductionItem.getIcon());
        }
    }

    public static void updateTurn(){
        String name = Globals.playerList.get(GameLogic.Turn.getTurn()).getName();
        playerTurn.setText("It's "+name+"'s Turn");
        if (city != null) {
            updateProductionItem();
            updateProductionList();
        }
        
    }
    
    private static Dimension getDimension(double x, double y){
        return Globals.settings.getDimension(x, y);
    }
    
    private static Point getPoint(double x, double y){
        return Globals.settings.getPoint(x, y);
    }

//------Varibles-Methods------------

    public static boolean isAttackingUnit() {
        return attackingUnit;
    }

    public static boolean isMovingUnit() {
        return movingUnit;
    }

    public static void setMovingUnit(boolean b) {
        if (b){
            movingUnit = true;
            unitMove.setIcon(new ImageIcon("src\\Resources\\unitMoveSelected.png"));
            Unit.setSelectedUnit(unit);
        }
        else{
            movingUnit = false; 
            unitMove.setIcon(new ImageIcon("src\\Resources\\unitMove.png"));
            Unit.setSelectedUnit(null);
        }      
    }   
}
