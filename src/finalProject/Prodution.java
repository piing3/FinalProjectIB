/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *Controls info on the things city's are able to build
 * 
 * @author Davin
 */
class Prodution {
    int productionCost;//the amount of production needed to make it
    String name;//the object's name
    String discription;//a discription of the object
    int productionChange = 0;//the change the object has on the city's production
    int goldChange = 0;//the change the object has on the city's gold
    int number;//the id the type of object uses when called below
    int unitType;//the id the object uses to make a unit
    Boolean rebuildable = true;//can the object be built multiple times in a simgle city
    Boolean isUnit = false;//does the object make a unit 
    Icon icon;
    Prodution(int object){
        number = object;//store the object number
        if (object == 0){//makes a warrior production element
            name = "Warrior";
            productionCost = 6;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "The basic melee unit. Avalable from the start.";
            rebuildable = true;
            isUnit = true;
            unitType = 1;
        }
        if (object == 1){//makes a archer production element
            name = "Archer";
            productionCost = 24;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "The basic Ragned unit. Avalable once Barracks is built.";
            rebuildable = true;
            isUnit = true;
            unitType = 3;
        }
        if (object == 2){//makes a settler production element
            name = "Settler";
            productionCost = 7;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Basic unit. able to settle new citys.";
            rebuildable = true;
            isUnit = true;
            unitType = 2;
        }
        if (object == 3){//makes a boat production element
            name = "Boat";
            productionCost = 15;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "The basic Naval Unit. Avalable once a Harbor is built.";
            rebuildable = true;
            isUnit = true;
            unitType = 4;
        }
        if (object == 4){//makes a worker production element
            name = "Worker";
            productionCost = 10;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Able to work and improve tiles";
            rebuildable = false;
        }
        //End of units, add more above if you want to add more units.
        if (object == 25){//makes a warrior production element
            name = "Barracks";
            productionCost = 10;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Building Required to build Ground Units.";
            rebuildable = false;
        }
        if (object == 24){//makes a warrior production element
            name = "Farm";
            productionCost = 20;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Building that provides Bonus food production.";
            rebuildable = false;
        }
        if (object == 23){//makes a warrior production element
            name = "Harbor";
            productionCost = 15;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Building Required to build Navel Units.";
            rebuildable = false;
        }
        if (object == 22){//makes a warrior production element
            name = "WorkShop";
            productionCost = 3;
            productionChange = 5;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "+5 Production";
            rebuildable = false;
        }
        //End of Buildings, add more above if you want to add more buildings.
    }
}
