/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.Random;

/**
 *Handles most of the turn related mechanics 
 * 
 * @author Ben (Tad bit to "organized")
 */
public class TurnOrder{
    /**
     * Determines which players turn it currently is
     * @return the current players id
     */
    public static int whoTurn(){
        int result = -1;

        if (FinalProject.Players.get(0).isTurn) result = 1;
            else  if (FinalProject.Players.get(1).isTurn) result = 2;
            else  if (FinalProject.Players.get(2).isTurn) result = 3;
            else  if (FinalProject.Players.get(3).isTurn) result = 4;
            return result;
    }
    /**
     * advances the game logic to the next players turn
     */
    public static void NextTurn(){
        FinalProject.turnNumber++;//increment counter
        
        if(FinalProject.play == 2){//if two players...(currently locked on this)
             Person player1 =       FinalProject.Players.get(0);//store player 1
             Person player2 =       FinalProject.Players.get(1);//store player 2
                 if(player1.isTurn){//if player 1's turn, change to player 2's 
                     FinalProject.Players.get(0).isTurn = false;
                     FinalProject.Players.get(1).isTurn = true;
                     City.updateCity(FinalProject.Players.get(1));//call the updateCity mechanic
                     UnitType.ResetUnits(whoTurn());//reset player 2's units
                     if (FinalProject.turnNumber == 1){//if it's players 2 first turn, spawn units
                        TurnOrder.spawnStart();
                     }
                 }
            else if(player2.isTurn){ //if player 2's turn, change to player 1's 
                     FinalProject.Players.get(0).isTurn = true;
                     FinalProject.Players.get(1).isTurn = false;
                     City.updateCity(FinalProject.Players.get(0));
                     UnitType.ResetUnits(whoTurn());//reset player 1's units
            }
        }
        if(FinalProject.play == 3){//same as above
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
             Person player3 =       FinalProject.Players.get(2);
                 if(player1.isTurn){
                     FinalProject.Players.get(0).isTurn = false;
                     FinalProject.Players.get(1).isTurn = true;
                     if (FinalProject.turnNumber == 1){
                        TurnOrder.spawnStart();
                     }
                 }
            else if(player2.isTurn){
                     FinalProject.Players.get(1).isTurn = false;
                     FinalProject.Players.get(2).isTurn = true;
                     if (FinalProject.turnNumber == 2){
                        TurnOrder.spawnStart();
                     }
            }
            else if(player3.isTurn){
                     FinalProject.Players.get(2).isTurn = false;
                     FinalProject.Players.get(0).isTurn = true;
            }
        }
        if(FinalProject.play == 4){//same as above
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
             Person player3 =       FinalProject.Players.get(2);
             Person player4 =       FinalProject.Players.get(3);
                 if(player1.isTurn){
                     FinalProject.Players.get(0).isTurn = false;
                     FinalProject.Players.get(1).isTurn = true;
                     if (FinalProject.turnNumber == 1){
                        TurnOrder.spawnStart();
                     }
                 }
            else if(player2.isTurn){
                     FinalProject.Players.get(1).isTurn = false;
                     FinalProject.Players.get(2).isTurn = true;
                     if (FinalProject.turnNumber == 2){
                        TurnOrder.spawnStart();
                     }
            }
            else if(player3.isTurn){
                     FinalProject.Players.get(2).isTurn = false;
                     FinalProject.Players.get(3).isTurn = true;
                     if (FinalProject.turnNumber == 3){
                        TurnOrder.spawnStart();
                     }
            }
            else if(player4.isTurn){
                     FinalProject.Players.get(3).isTurn = false;
                     FinalProject.Players.get(0).isTurn = true;
            }
        }
        
        int index = UnitType.FindUnit(whoTurn());//repositions the map to a unit of the current turn
        if (FinalProject.units.get(index).x > Map.x)Visual.rightOff = FinalProject.units.get(index).x - (Map.x/2);
        else Visual.downOff = FinalProject.units.get(index).x;
        if (FinalProject.units.get(index).y > Map.y)Visual.downOff = FinalProject.units.get(index).y - (Map.y/2);
        else Visual.rightOff = FinalProject.units.get(index).y; 
        Visual.redrawMap();
        Visual.LoadUnits();
    }
    /**
     *spawns in a settler and warrior at a random location
     */
    public static void spawnStart() {
        Random startPos = new Random();//random
        int startX;//x pos
        int startY;//y pos
        boolean loopPass = false;// conditon to be met
        do{
            startX = startPos.nextInt(126);//set both to a random location
            startY = startPos.nextInt(70);
            loopPass = true;
            if (Map.grid[startX][startY].tileType == 2) loopPass = false;//if location is water
            if (13 > startX || startX > 115) loopPass = false;//if too close to edges
            if (7 > startY || startY > 65) loopPass = false;
            for (int i = -10; i < 10; i++) {
                for (int j = -10; j < 10; j++) {
                    if(UnitType.FindUnit(startX + i, startY + j) != -1) loopPass = false;//if too close to other player
                }
            }
        }while(loopPass == false);
        UnitType.CreateUnit(startX, startY, 1,Visual.Units);//make units
        UnitType.CreateUnit(startX + 1, startY, 2,Visual.Units);
        if (startX > Map.x)Visual.rightOff = startX - (Map.x/2);//move view to new location
        else {Visual.rightOff = 0;}
        if (startY > Map.y)Visual.downOff = startY - (Map.y/2);
        else{ Visual.downOff = 0;}
        Visual.redrawMap();
        Visual.LoadUnits();
    }
}