/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Deborah
 */
class Frame extends JFrame implements KeyListener{
    
    final Tile[][] TILE_GRID = new Tile[30][18];
    final int[][] GRID_DATA = new int[500][500];
    
    int downOff;
    int rightOff;
    
    ArrayList<Unit> units = new ArrayList<>();
    int[][] unitGrid = new int[500][500]; 
    
    public Frame() {
        
        Random r = new Random();
        downOff = r.nextInt(481);
        rightOff = r.nextInt(499);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
        
        for (int i = 0; i < 499; i++) {
            for (int j = 0; j < 499; j++) {
                GRID_DATA[i][j] = -1;
            }
        }
        SeedTiles();
        GrowTiles();
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 17; j++) {
                TILE_GRID[i][j] = new Tile(i,j, this);
                TILE_GRID[i][j].setBase(GRID_DATA[i+rightOff][j+downOff]);
            }
        }
        this.setVisible(true);
        
        Unit test = new Unit();
    }

    private void SeedTiles() {
        Random random = new Random();
        for (int i = 0; i < 1250; i++) {
            GRID_DATA[random.nextInt(499)][random.nextInt(499)] = random.nextInt(3);
        }
        
    }

    private void GrowTiles() {
        boolean gate = true;
        while (gate) {
            gate = false;
            for (int i = 0; i < 499; i++) {
                for (int j = 0; j < 499; j++) {
                    if(GRID_DATA[i][j] == -1){
                        gate = true;
                        Random r = new Random();
                        int direction = r.nextInt(4);
                        if (direction == 0 && i != 499) GRID_DATA[i][j] = GRID_DATA[i+1][j];
                        if (direction == 1 && i != 0) GRID_DATA[i][j] = GRID_DATA[i-1][j];
                        if (direction == 0 && i == 499) GRID_DATA[i][j] = GRID_DATA[0][j];
                        if (direction == 1 && i == 0) GRID_DATA[i][j] = GRID_DATA[499][j];
                        if (direction == 2 && j != 499) GRID_DATA[i][j] = GRID_DATA[i][j+1];
                        if (direction == 3 && j != 0) GRID_DATA[i][j] = GRID_DATA[i][j-1];
                        if (j == 0 || j == 499) GRID_DATA[i][j] = 2; 
                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38){//up
                if (downOff != 0){
                    downOff--;
                }
                redrawMap();
        }
        if (e.getKeyCode() == 37){//left
            rightOff--;
            if(rightOff == -30) rightOff = 469;
            redrawMap();
        }
        if (e.getKeyCode() == 40){//down

            if (downOff != (500-18)){
                downOff++;    
            }
            redrawMap();
        }
        if (e.getKeyCode() == 39){//right
            rightOff++;
            if(rightOff == 529) rightOff = 30;
            redrawMap();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void redrawMap(){
        for (int i = 0; i < 29; i++){
            for (int j = 0; j < 17; j++){
                if (i + rightOff > 499){
                    int diffrence = i + rightOff - 500;
                    TILE_GRID[i][j].setBase(GRID_DATA[diffrence][j + downOff]);
                    
                }
                
                else if (i+rightOff < 0){
                    int diffrence = i+rightOff + 500;
                    TILE_GRID[i][j].setBase(GRID_DATA[diffrence][j + downOff]);
                    if (rightOff == -30) rightOff = 470;
                }
                
                else TILE_GRID[i][j].setBase(GRID_DATA[i + rightOff][j + downOff]);
                System.out.println("RightOff: " + rightOff);
            }
        }
    }
    
    public void LoadUnits(){
        for (int i = 0; i <= 127; i++){
            for (int j = 0; j <= 71; j++){
                if (FindUnit(i,j) > -1){
                    int index = FindUnit(i,j);
                    Unit unit = units.get(index);
                    if (unit.x == i&& unit.y == j){
                        unit.setLocation((i- rightOff)*50, (j- downOff)*50);
                        unit.setUnit(unitGrid[i][j]);
                    }
                }
            }
        }
    }
    
    public int FindUnit(int x, int y){
        int result = -1;
        if (units.size() <= 0){
        }
        for (int i = 0; i < units.size(); i++) {
            Unit unit = units.get(i);
            if (unit.x == x && unit.y  == y){
                result = i;
            }
        }
        return result;
    } 
}
