/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;
/**
 *
 * @author hmamin
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard() {
        super(0, 0);
    }
 
    public PersonalBoard(int width, int height) {
        // They seem to have defined width as number of rows.
        super(width, height);
    }
    
    public boolean[][] getBoard() {
        return super.getBoard();
    }
    
    public int getWidth() {
        return super.getWidth();
    }
    
    public int getHeight() {
        return super.getHeight();
    }
    
    public void playTurn() {
        for (int i=0; i<getWidth(); i++) {
            for (int j=0; j<getHeight(); j++) {
                int livingNeighbours = getNumberOfLivingNeighbours(i, j);
                manageCell(i, j, livingNeighbours);
            }
        }
    }
    
    public void turnToLiving(int x, int y) {
        if (x >= 0 & x < getWidth() & y >= 0 & y < getHeight()) {
            getBoard()[x][y] = true;
        }
    }
    
    public void turnToDead(int x, int y) {
        if (x >= 0 & x < getWidth() & y >= 0 & y < getHeight()) {
            getBoard()[x][y] = false;
        }
    }
    
    public boolean isAlive(int x, int y) {
        if (x >= 0 & x < getWidth() & y >= 0 & y < getHeight()) {
            return getBoard()[x][y];
        }
        
        return false;
    }
    
    public void initiateRandomCells(double prob) {
        Random random = new Random();
        
        for (int i=0; i<getWidth(); i++) {
            for (int j=0; j<getHeight(); j++) {
                if (random.nextDouble() <= prob) {
                    getBoard()[i][j] = true;
                } else {
                    getBoard()[i][j] = false;
                }
            }
        }
    }
    
    public int getNumberOfLivingNeighbours(int x, int y) {
        int total = 0;

        for (int i=Math.max(0, x-1); i<Math.min(getWidth(), x+2); i++) {
            for (int j=Math.max(0, y-1); j<Math.min(getHeight(), y+2); j++) {
                if (getBoard()[i][j] & !(i == x & j == y)) {
                    total++;
                }
            }
        }
        
        return total;
    }

    public void manageCell(int i, int j, int livingNeighbours) {
        if (livingNeighbours < 2 | livingNeighbours > 3) {
            turnToDead(i, j);
        } else if (livingNeighbours == 3) {
            turnToLiving(i, j);
        }
    }
    
    public String toString() {
        String output = "";
        
        for (boolean[] row:getBoard()) {
            output += "[";
            
            for (boolean num:row) {
                output += num + " ";
            }
            
            output += "]\n";
        }
        
        return output;
    }

}
