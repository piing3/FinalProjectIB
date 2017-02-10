/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import sun.awt.AWTAccessor;

/**
 *handles all user interface mechanics
 * @author Davin
 */
class UserInt {
    
        public JButton nextTurn;//normal ui components
        public JLabel PlayerTurn;
        
        static public JButton cityTest = new JButton();//city ui components
        static public City city = new City();
        static public Unit unit = new Unit(); 
        static public JLabel cityLeft;
        static public JLabel cityGold;
        static public JLabel cityFood;
        static public JLabel cityScience;
        static public JLabel cityProduction;
        static public JLabel cityName; 
        static public JPanel productionBackrounds = new JPanel();
        static public JScrollPane jsp = new JScrollPane();
        static public JPanel SelectedProduction = new JPanel(null);
        static public Prodution selectedProductionItem = new Prodution(-1);
        static public JLabel selectedIcon;
        static public JLabel selectedTitle;
        static public JLabel selectedCost;
        static public JLabel selectedDicription;
        
        static public JLabel unitBack;//unit ui components 
        static public JLabel unitHealth; 
        static public JLabel unitStrength; 
        static public JLabel unitMoves; 
        static public JLabel unitName; 
        static public JButton unitMove;
        static public JButton unitSettle;
        static public JButton unitAttack;
        static public JLabel unitIcon;
        
        static public ArrayList<JPanel> productionPanelList = new ArrayList<JPanel>();//production lists
        static public ArrayList<JButton> productionButtonList = new ArrayList<JButton>();
        

    
    UserInt() throws FileNotFoundException{
        
        nextTurn = new JButton("Next Turn");//make nextTurn button
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOrder.NextTurn();
                System.out.println(TurnOrder.whoTurn());
                PlayerTurn.setText(FinalProject.Players.get(TurnOrder.whoTurn()-1).name+"'s Turn");
                
                
            }
        };
        nextTurn.addActionListener(actionListener);
        nextTurn.setSize(200, 25); 
        nextTurn.setLocation(Visual.width - 200, Visual.hight - 175);
        nextTurn.setBackground(Color.orange);
        nextTurn.setFocusable(false);
        Visual.UI.add(nextTurn);
        
        PlayerTurn = new JLabel(FinalProject.Players.get(TurnOrder.whoTurn()-1).name+"'s Turn");//make playerTurn label 
        PlayerTurn.setSize(200, 20);
        PlayerTurn.setLocation(Visual.width - 200, Visual.hight - 195);
        PlayerTurn.setHorizontalAlignment(SwingConstants.CENTER);
        PlayerTurn.setForeground(Color.BLACK);
        Visual.UI.add(PlayerTurn);
        
        JPanel UIBackround = new JPanel();//make UIBackround
        UIBackround.setLocation(Visual.width - 200, Visual.hight - 200);
        UIBackround.setSize(200, 200);
        UIBackround.setBackground(Color.GRAY);
        Visual.UI.add(UIBackround);
        
        MakeCityUI();//make the city ui
        MakeUnitUI();//make the unit ui

        }
    /**
     * opens the city UI of the given city
     * @param newCity: the city to open
     */
    public static void CityUI(City newCity){        
        city = newCity;
        
        updateProductionList();
        updateSelectedProduction();
        visibleCityUI(true);
        visibleUnitUI(false);
        
        updateFood();
        updateGold();
        updateProduction();
        updateCityName();
        
    }
    /**
     * open the unit UI of the given unit
     * @param newUnit: the unit to open 
     */
    public static void UnitUI(Unit newUnit){   
        unit = newUnit;
        
        visibleCityUI(false);        
        visibleUnitUI(true);
        
        updateHealth();
        updateStength();
        updateMoves();
        updateIcon();
        unitName.setText(unit.name);
    }
    /**
     * closes city and unit UI
     */
    public static void NormalUI(){        
        visibleCityUI(false);
        visibleUnitUI(false);
        
    }
    
    public static void updateGold() {cityGold.setText(city.gold+"");}//updates the cityGold label
    public static void updateFood() {cityFood.setText(city.food+"");}//updates the cityFood label
    public static void updateProduction() {cityProduction.setText(city.production+"");}//updates the cityProduction label
    public static void updateCityName() {cityName.setText(city.name+" ("+city.population+")");}//updates the cityName label
    /**
     * changes which object is being shown below the production menu
     */
    public static void updateSelectedProduction() {
        selectedProductionItem = city.productionItem ;
        double oneRaw = city.productionLeft/city.production;
        int one = city.productionLeft/city.production;
        if (oneRaw > one) one++; 
        
        int two = selectedProductionItem.productionCost/city.production;
        double twoRaw = selectedProductionItem.productionCost/city.production;
        if (twoRaw > two) two++; 
        selectedCost.setText(one+" / "+two);
        selectedTitle.setText(selectedProductionItem.name+"");
        selectedDicription.setText(selectedProductionItem.discription+"");
        selectedIcon.setIcon(selectedProductionItem.icon);
    }
    
    public static void updateHealth() {unitHealth.setText(unit.health+"");}//updates the unitHealth label
    public static void updateStength(){unitStrength.setText(unit.Damage+"");}//updates the unitStrength label
    public static void updateMoves(){unitMoves.setText(unit.movement+"");}//updates the unitMoves label
    public static void updateIcon(){unitIcon.setIcon(unit.unitIcon);}//updates the unitIcon label
    
    /**
     * creates all the city UI elements
     */
    public void MakeCityUI(){
        
        Icon leftBack = new ImageIcon("src\\Images\\CityLeft.png");
        cityLeft = new JLabel(leftBack);
        cityLeft.setSize(394,734);
        cityLeft.setLocation(-5,0);
        cityLeft.setVisible(false);
        cityLeft.setFocusable(false);
        Visual.CityUI.add(cityLeft,0);
        
        cityFood = new JLabel();
        cityFood.setSize(100,20);
        cityFood.setLocation(350,55);
        cityFood.setFont(new Font(null, Font.PLAIN, 20));
        cityFood.setForeground(Color.green);
        cityFood.setVisible(false);
        cityFood.setFocusable(false);
        Visual.CityUI.add(cityFood, 0);
        
        cityProduction = new JLabel();
        cityProduction.setSize(100,20);
        cityProduction.setLocation(350,90);
        cityProduction.setFont(new Font(null, Font.PLAIN, 20));
        cityProduction.setForeground(Color.orange);
        cityProduction.setVisible(false);
        cityProduction.setFocusable(false);
        Visual.CityUI.add(cityProduction, 0);
        
        cityScience = new JLabel();
        cityScience.setSize(100,20);
        cityScience.setLocation(350,120);
        cityScience.setFont(new Font(null, Font.PLAIN, 20));
        cityScience.setForeground(Color.blue);
        cityScience.setVisible(false);
        cityScience.setFocusable(false);
        Visual.CityUI.add(cityScience, 0);
        
        cityGold = new JLabel();
        cityGold.setSize(100,20);
        cityGold.setLocation(350,155);
        cityGold.setFont(new Font(null, Font.PLAIN, 20));
        cityGold.setForeground(Color.yellow);
        cityGold.setVisible(false);
        cityGold.setFocusable(false);
        Visual.CityUI.add(cityGold, 0);
        
        cityName = new JLabel();
        cityName.setSize(384,40);
        cityName.setLocation(0,10);
        cityName.setFont(new Font(null, Font.PLAIN, 40));
        cityName.setForeground(Color.BLACK);
        cityName.setVisible(false);
        cityName.setFocusable(false);
        cityName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Visual.CityUI.add(cityName, 0);
        MakeProductionUI();
    }
    /**
     * makes all the unit UI elements
     */
    public void MakeUnitUI(){
        Icon unitBackround = new ImageIcon("src\\Images\\UnitBackround.png");
        unitBack = new JLabel(unitBackround);
        unitBack.setSize(600,220);
        unitBack.setLocation(0, 490);
        unitBack.setVisible(false);
        unitBack.setFocusable(false);
        Visual.UnitUI.add(unitBack,0);
        
        unitIcon = new JLabel();
        unitIcon.setSize(200,200);
        unitIcon.setLocation(20, 500);
        unitIcon.setVisible(false);
        unitIcon.setFocusable(false);
        Visual.UnitUI.add(unitIcon,0);
        
        unitHealth = new JLabel();
        unitHealth.setSize(100, 20);
        unitHealth.setLocation(450, 540);
        unitHealth.setVisible(false);
        unitHealth.setFocusable(false);
        unitHealth.setFont(new Font(null, Font.PLAIN, 20));
        Visual.UnitUI.add(unitHealth,0);
        
        unitStrength = new JLabel();
        unitStrength.setSize(100, 20);
        unitStrength.setLocation(450, 575);
        unitStrength.setVisible(false);
        unitStrength.setFocusable(false);
        unitStrength.setFont(new Font(null, Font.PLAIN, 20));
        Visual.UnitUI.add(unitStrength,0);
        
        unitMoves = new JLabel();
        unitMoves.setSize(100, 20);
        unitMoves.setLocation(450, 610);
        unitMoves.setVisible(false);
        unitMoves.setFocusable(false);
        unitMoves.setFont(new Font(null, Font.PLAIN, 20));
        Visual.UnitUI.add(unitMoves,0);
        
        unitName = new JLabel();
        unitName.setSize(390, 30);
        unitName.setLocation(210, 500);
        unitName.setVisible(false);
        unitName.setFocusable(false);
        unitName.setFont(new Font(null, Font.PLAIN, 30));
        unitName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Visual.UnitUI.add(unitName,0);
        
        Icon imgMove = new ImageIcon("src\\Images\\unitMove.png");
        unitMove = new JButton(imgMove);
        ActionListener move = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Icon imgMove = new ImageIcon("src\\Images\\unitMove.png");
                Icon imgMoveSelected = new ImageIcon("src\\Images\\unitMoveSelected.png");
                if (!Visual.movingUnit){Visual.movingUnit = true; unitMove.setIcon(imgMoveSelected);}
                else {Visual.movingUnit = false; unitMove.setIcon(imgMove);}

            }
        };
        unitMove.addActionListener(move);
        unitMove.setSize(50, 50);
        unitMove.setLocation(0, 440);
        unitMove.setVisible(false);
        unitMove.setFocusable(false);
        Visual.UnitUI.add(unitMove,0);
           
        Icon imgSettle = new ImageIcon("src\\Images\\unitSettle.png");
        unitSettle = new JButton(imgSettle);
        ActionListener settle = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Visual.FindCity(unit.x, unit.y);
                if (index == -1)
                {
                    FinalProject.cities.add(new City(unit.x, unit.y, TurnOrder.whoTurn()-1));
                    int UnitIndex = UnitType.FindUnit(unit.x, unit.y);
                    UnitType.Death(UnitIndex);
                    CityUI(FinalProject.cities.get(Visual.FindCity(unit.x, unit.y)));
                } 
                
            }
        };
        unitSettle.addActionListener(settle);
        unitSettle.setSize(50, 50);
        unitSettle.setLocation(0, 380);
        unitSettle.setVisible(false);
        unitSettle.setFocusable(false);
        Visual.UnitUI.add(unitSettle,0);
           
        Icon imgAttack = new ImageIcon("src\\Images\\unitAttack.png");
        unitAttack = new JButton(imgAttack);
        ActionListener attack = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Icon imgAttack = new ImageIcon("src\\Images\\unitAttack.png");
                Icon imgAttackSelected = new ImageIcon("src\\Images\\unitAttackSelected.png");
                if (!Visual.attackingUnit){Visual.attackingUnit = true; unitAttack.setIcon(imgAttackSelected);}
                else {Visual.attackingUnit = false; Visual.attackingUnit = false;unitAttack.setIcon(imgAttack);} 
                
            }
        };
        unitAttack.addActionListener(attack);
        unitAttack.setSize(50, 50);
        unitAttack.setLocation(0, 380);
        unitAttack.setVisible(false);
        unitAttack.setFocusable(false);
        Visual.UnitUI.add(unitAttack,0);
    }
    /**
     * makes all the production UI elements(part of city UI)
     */
    public void MakeProductionUI() {
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setSize(new Dimension(384, 350));
        jsp.setLocation(0, 200);
        jsp.setViewportView(productionBackrounds);
        Visual.CityUI.add(jsp,0);
        jsp.setVisible(false);
        productionBackrounds.setBackground(Color.BLACK);
        productionBackrounds.setLayout(new BoxLayout(productionBackrounds, BoxLayout.Y_AXIS));
        
        SelectedProduction.setLayout(null);
        SelectedProduction.setBackground(Color.GRAY);
        SelectedProduction.setSize(384, 150);
        SelectedProduction.setLocation(0, 554);
        SelectedProduction.setVisible(false);
        Visual.CityUI.add(SelectedProduction,0);
        
        Icon backroundImage = new ImageIcon("src\\Images\\ProductionBack.png");
        JLabel selectedBackround = new JLabel(backroundImage);
        selectedBackround.setSize(385, 150);
        selectedBackround.setLocation(0, 0);
        SelectedProduction.add(selectedBackround, 0);
        
        selectedTitle = new JLabel();
        selectedTitle.setSize(200, 30);
        selectedTitle.setLocation(220, 10);
        selectedTitle.setFont(new Font(null, Font.PLAIN, 30));
        selectedTitle.setForeground(Color.BLACK);
        SelectedProduction.add(selectedTitle, 0);

        selectedCost = new JLabel();
        selectedCost.setSize(100, 20);
        selectedCost.setLocation(325, 50);
        selectedCost.setFont(new Font(null, Font.PLAIN, 20));
        selectedCost.setForeground(Color.BLACK);
        SelectedProduction.add(selectedCost, 0);

        selectedDicription = new JLabel();//ask Wachs how to wrap text
        selectedDicription.setSize(150, 50);
        selectedDicription.setLocation(210, 90);
        selectedDicription.setFont(new Font(null, Font.PLAIN, 15));
        selectedDicription.setForeground(Color.BLACK);
        SelectedProduction.add(selectedDicription, 0);
        
        selectedIcon = new JLabel();
        selectedIcon.setSize(150, 150);
        selectedIcon.setLocation(20, 0);
        SelectedProduction.add(selectedIcon, 0);
        
    }
    /**
     * sets all the city UI elements to the given visibility 
     * @param visable:the given visibility 
     */
    public static void visibleCityUI(boolean visible){
        cityTest.setVisible(visible);
        cityLeft.setVisible(visible);
        cityFood.setVisible(visible);
        cityGold.setVisible(visible);
        cityProduction.setVisible(visible);
        cityScience.setVisible(visible);
        cityName.setVisible(visible);
        jsp.setVisible(visible);
        SelectedProduction.setVisible(visible); 
    }
    /**
     * sets all the unit UI elements to the given visibility 
     * @param visable:the given visibility 
     */
    public static void visibleUnitUI(boolean visible){
        unitBack.setVisible(visible);
        unitHealth.setVisible(visible);
        unitStrength.setVisible(visible);
        unitMoves.setVisible(visible);
        unitMove.setVisible(visible);
        unitName.setVisible(visible);
        unitIcon.setVisible(visible);
        if (unit.type == 2) unitSettle.setVisible(visible);
        else unitSettle.setVisible(false);
        
        if (unit.type == 1) unitAttack.setVisible(visible);
        else unitAttack.setVisible(false);
    }
    /**
     * updates the city UI's list of build objects
     */
    public static void updateProductionList(){
        productionPanelList.clear();
        productionBackrounds.removeAll();
        for (int i = 0; i < city.cityBuildObjects.size(); i++) {
            JPanel productionInfo = new JPanel();
            productionInfo.setLayout(null);
            productionInfo.setBackground(Color.BLACK);
            productionInfo.setPreferredSize(new Dimension(384, 160));
            productionBackrounds.add(productionInfo);
            productionPanelList.add(productionInfo);
            
            Icon backroundImage = new ImageIcon("src\\Images\\ProductionBack.png");
            JLabel backround = new JLabel(backroundImage);
            backround.setSize(385, 150);
            backround.setLocation(0, 0);
            productionInfo.add(backround, 0);
            
            Prodution thing = new Prodution(city.cityBuildObjects.get(i));
            JLabel title = new JLabel(thing.name);
            title.setSize(200, 30);
            title.setLocation(220, 10);
            title.setFont(new Font(null, Font.PLAIN, 30));
            title.setForeground(Color.BLACK);
            productionInfo.add(title, 0);
            
            JLabel cost = new JLabel(thing.productionCost+"");
            cost.setSize(100, 20);
            cost.setLocation(325, 50);
            cost.setFont(new Font(null, Font.PLAIN, 20));
            cost.setForeground(Color.BLACK);
            productionInfo.add(cost, 0);
            
            JLabel dicription = new JLabel(thing.discription);//ask Wachs how to wrap text
            dicription.setSize(150, 50);
            dicription.setLocation(210, 90);
            dicription.setFont(new Font(null, Font.PLAIN, 15));
            dicription.setForeground(Color.BLACK);
            productionInfo.add(dicription, 0);
            
            JButton select = new JButton("Select");
            select.setSize(100, 25);
            select.setLocation(230, 125);
            select.setForeground(Color.BLACK);
            select.setBackground(Color.GRAY);
            select.setFocusable(false);
            productionInfo.add(select, 0);
            ActionListener setProduction = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton trigger = (JButton)e.getSource();
                    for (int i = 0; i < productionPanelList.size(); i++) {
                        Component[] test = productionPanelList.get(i).getComponents();
                        for (int j = 0; j < test.length; j++) {
                            if (test[j] == trigger){
                                if (selectedProductionItem.number != new Prodution(city.cityBuildObjects.get(i)).number){
                                    selectedProductionItem = new Prodution(city.cityBuildObjects.get(i));
                                    city.productionItem = selectedProductionItem;
                                    city.productionLeft = selectedProductionItem.productionCost;
                                    updateSelectedProduction();
                                }
                            }
                        } 
                    }
                }
            };
            select.addActionListener(setProduction);
            
            JLabel icon = new JLabel(thing.icon);
            icon.setSize(150, 150);
            icon.setLocation(10, 0);
            productionInfo.add(icon, 0);
        }
    }
}
