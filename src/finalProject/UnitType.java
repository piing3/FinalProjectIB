/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Container;


/**
 *Stores most of the mechanics for units
 * @author Ben Allen
 */
class UnitType {
    final static int WATER = 2;//finals
    final static int CITY = 100;
    final static int EMPTY = -1;
    final static int YLENGTH = 128;
    final static int XWIDTH = 72;
    final static int BORDER = 3;
    
    /**
     * Makes a unit using the given info
     * @param x: x pos
     * @param y: y pos
     * @param type: unit type
     * @param container: the container to add it to
     */
    public  static void CreateUnit(int x, int y, int type, Container container){
        if (FinalProject.units.isEmpty()){//fill the unit grid with 0 if it's empty
            Globals.unitGrid  = new int[YLENGTH][XWIDTH];
            for (int i = 0; i < Globals.unitGrid.length; i++) {
                for (int j = 0; j < Globals.unitGrid[i].length; j++) {
                    Globals.unitGrid[i][j] = 0;
                }
            }
        }
        int owner = TurnOrder.whoTurn();//gets current player
        FinalProject.units.add(new Unit(x, y, type,container, owner));//make unit
        Globals.unitGrid[x][y] = type;//add to grid
        Visual.LoadUnits();//reload units
        
   
    }
    /**
     * Returns the index of the unit a the given location
     * @param x: x pos
     * @param y: y pos
     * @return: the index of the unit
     */
    public static int FindUnit(int x, int y){
        int result = EMPTY;
        if (FinalProject.units.size() <= 0){
        }
        for (int i = 0; i < FinalProject.units.size(); i++) {
            Unit unit = FinalProject.units.get(i);
            if (unit.x == x && unit.y  == y){
                result = i;
            }
        }
        return result;
    } 
    /**
     * Returns the index of the first unit of the given player
     * @param owner: the player 
     * @return: the index of the players first unit
     */
    public static int FindUnit(int owner){
        int result = EMPTY;
        for (int i = 0; i < FinalProject.units.size(); i++) {
            if (FinalProject.units.get(i).player == owner){
                result = i;
            }
        }
        return result;
        
    }
    /**
     * Moves the unit with the given index to the given location
     * @param index: the unit's index
     * @param newX: the x pos to move to
     * @param newY: the y pos to move to
     */
    public static void MoveGround(int index, int newX, int newY){
    Unit unit = FinalProject.units.get(index);
    if (FindUnit(newX, newY) == EMPTY){
        if (Tile.getTileType(Map.grid[newX][newY]) != WATER && Tile.getTileType(Map.grid[newX][newY]) != BORDER){
            if (unit.movement > 0){
                if (unit.x + 1 == newX || unit.x -1 == newX || unit.x == newX){
                     if (unit.y + 1 == newY || unit.y -1 ==newY || unit.y == newY){
                         if (TurnOrder.whoTurn() == unit.player){
                        Globals.unitGrid[unit.x][unit.y] = 0;
                        Globals.unitGrid[newX][newY] = unit.type;
                        FinalProject.units.get(index).movement--;
                        FinalProject.units.get(index).x = newX;
                        FinalProject.units.get(index).y = newY;
                        FinalProject.units.get(index).setLocation(newX*50, newY*50);
                        Visual.LoadUnits(); 
                            }
                        }                      
                    }                                                                                                                                                                                                                                                                                                                                                                                             
                }
            }
        }
    }
    /**
     * Moves the unit with the given index to the given location
     * @param index: the unit's index
     * @param newX: the x pos to move to
     * @param newY: the y pos to move to
     */
    public static void MoveWater(int index, int newX, int newY){
        Unit unit = FinalProject.units.get(index);
        if (FindUnit(newX, newY) == EMPTY){
            if (Tile.getTileType(Map.grid[newX][newY]) == WATER || Tile.getTileType(Map.grid[newX][newY]) == CITY) {
                if (unit.movement > 0){
                    if (unit.x + 1 == newX || unit.x -1 == newX || unit.x == newX){
                        if (unit.y + 1 == newY || unit.y -1 ==newY || unit.y == newY) {
                            Globals.unitGrid[unit.x][unit.y] = 0;
                            Globals.unitGrid[newX][newY] = unit.type;
                            if (TurnOrder.whoTurn() == unit.player) {
                                Globals.unitGrid[unit.x][unit.y] = 0;
                            Globals.unitGrid[unit.x][unit.y] = unit.type;
                            FinalProject.units.get(index).movement -= 1;
                            FinalProject.units.get(index).x = newX;
                            FinalProject.units.get(index).y = newY;
                            FinalProject.units.get(index).setLocation(newX*50, newY*50);
                            Visual.LoadUnits();
                            }
                        } 
                    }
                }
            }
        }
    }
    /**
     * removes the given unit from the game
     * @param index: the index of the unit 
     */
    public static void Death(int index){
        Unit unit = FinalProject.units.get(index);
        Globals.unitGrid[unit.x][unit.y] = -1;
        unit.setUnit(-1);
        FinalProject.units.remove(index);
        Visual.LoadUnits();
    }
    /**
     * resets all units of the given player
     * @param owner: the player  
     */
    public static void ResetUnits(int owner){
        for (int i = 0; i < FinalProject.units.size(); i++) {
            if (FinalProject.units.get(i).player == owner) FinalProject.units.get(i).SetMove(FinalProject.units.get(i)); 
        }
    }
    /**
     * makes two units attack each other
     * @param unitOneIndex: index of unit one
     * @param unitTwoIndex: index of unit two
     */
    public static void Attack(int unitOneIndex, int unitTwoIndex){
        Unit unitOne = FinalProject.units.get(unitOneIndex);
        Unit unitTwo = FinalProject.units.get(unitTwoIndex);
        if (unitOne.type != 3) {//not boat
                if (unitOne.x + 1 == unitTwo.x || unitOne.x -1 == unitTwo.x || unitOne.x == unitTwo.x){
                     if (unitOne.y + 1 == unitTwo.y || unitOne.y -1 == unitTwo.y || unitOne.y == unitTwo.y){
                            unitTwo.health -= unitOne.Damage;
                            if (unitTwo.health <= 0) Death(unitTwoIndex);
                            if (unitTwo.type != 3) {
                            FinalProject.units.get(unitTwoIndex).health = unitTwo.health;
                            unitOne.health -= unitTwo.Damage;
                            FinalProject.units.get(unitOneIndex).health = unitOne.health;
                            if (unitOne.health <= 0) Death(unitOneIndex); 
                                }
                            }
                        }
        
        }
        else if (unitOne.type == 3) {//boat
            if (unitOne.x + 2 >= unitTwo.x || unitOne.x -2 >= unitTwo.x || unitOne.x >= unitTwo.x){
                     if (unitOne.y + 2 >= unitTwo.y || unitOne.y - 2 >= unitTwo.y || unitOne.y >= unitTwo.y){
                            unitTwo.health -= unitTwo.Damage;
                                }
                        }
        if (unitTwo.health <= 0) Death(unitTwoIndex);
        else{
            FinalProject.units.get(unitTwoIndex).health = unitTwo.health;
        }
        
        }
        
    }
    /**
     * has a unit attack a city
     * @param unitOneIndex: index of the unit
     * @param CityIndex: index of the city 
     */
    public static void AttackCity(int unitOneIndex, int CityIndex){
        Unit unit = FinalProject.units.get(unitOneIndex);
        int cityHealth = FinalProject.cities.get(CityIndex).Health;
        int cityX = FinalProject.cities.get(CityIndex).x;
        int cityY = FinalProject.cities.get(CityIndex).y;
        int cityDamage = FinalProject.cities.get(CityIndex).Damage;
        if (unit.type == 1){
            cityHealth -= unit.Damage;
        }
        else if(unit.type == 0 || unit.type == 4){
            cityHealth -= unit.Damage;
            if (cityHealth <= 0){
                FinalProject.cities.get(CityIndex).Health -= cityHealth;
                if(unit.type == 0){
                    MoveGround(unitOneIndex, cityX, cityY);
                }
                else if(unit.type == 4){
                    MoveWater(unitOneIndex, cityX, cityY);
                }
            }
            else if(cityHealth > -0){
                FinalProject.units.get(unitOneIndex).health -= cityDamage;
            }
        }
    }
}
