/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Random random;
    private Scanner reader;
    private int row;
    private int col;
    // Coordinate order: (col, row).
    private List<ArrayList<Integer>> vampireCoords;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.random = new Random();
        this.reader = new Scanner(System.in);
        
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.vampireCoords = initializeVampireCoords();        
        
        // Player starts at (col 0, row 0).
        this.col = 0;
        this.row = 0;
    }
    
    public List<ArrayList<Integer>> initializeVampireCoords() {
        vampireCoords = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<this.vampires; i++) {
            ArrayList<Integer> coords = new ArrayList<Integer>();
            int currX = 0;
            int currY = 0;
            while (currX == 0 & currY == 0) {
                currX = this.random.nextInt(this.length);
                currY = this.random.nextInt(this.height);
            }
            coords.add(currX);
            coords.add(currY);
            vampireCoords.add(coords);
        }
        
        return vampireCoords;
    }
    
    public void run() {
        while (this.moves > 0) {
            System.out.println(this.moves);
            printLocations();
            printBoard();
            String cmd = this.reader.nextLine();
            movePlayer(cmd);
            if (this.vampiresMove) {
                moveVampires();
            }
            removeVampires();
            
            if (this.vampireCoords.isEmpty()) {
                System.out.println("YOU WIN");
                return;
            }
            
            this.moves--;
        }
        
        System.out.println("YOU LOSE");
    }
    
    public void printLocations() {
        System.out.println("\n@ " + this.col + " " + this.row);
        for (ArrayList<Integer> coords:this.vampireCoords) {
            System.out.print("v ");
            String coordString = coords.toString().replace(",", "");
            System.out.println(coordString.substring(1, coordString.length() - 1));
        }
    }
    
    public void printBoard() {
        System.out.println("");
        for (int i=0; i<this.height; i++) {
            for (int j=0; j<this.length; j++) {
                ArrayList<Integer> coords = new ArrayList<Integer>();
                coords.add(i);
                coords.add(j);
                
                if (i == this.row & j == this.col) {
                    System.out.print("@");
                } else if (this.vampireCoords.contains(coords)) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }
            }
            
            System.out.println("");
        }
    }
    
    public void moveVampires() {
        for (ArrayList<Integer> coords:this.vampireCoords) {
            int col = coords.get(0);
            int row = coords.get(1);
            
            int newCol = col;
            int newRow = row;
            
            // Ensure that vampire moves to new position.
            while (col == newCol & row == newRow) {
                 newCol += this.random.nextInt(3) - 1;
                 newRow +=  + this.random.nextInt(3) - 1;
                 
                // Ensure that new coordinates don't lie outside board.
                newCol = Math.min(Math.max(0, newCol), this.length-1);
                newRow = Math.min(Math.max(0, newRow), this.height-1);
            }
            
            coords.set(0, newCol);
            coords.set(1, newRow);
        }
    }
    
    public void movePlayer(String cmd) {
        for (int i=0; i<cmd.length(); i++) {
            char c = cmd.charAt(i);
            if (c == 'w' & this.row > 0) {
                this.row--;
            } else if (c == 's' & this.row < this.height - 1) {
                this.row++;
            } else if (c == 'a' & this.col > 0) {
                this.col--;
            } else if (c == 'd' & this.col < this.length - 1) {
                this.col++;
            }
        }
    }
    
    public void removeVampires() {
        ArrayList<Integer> playerCoords = new ArrayList<Integer>();
        playerCoords.add(this.row);
        playerCoords.add(this.col);
        
        while (this.vampireCoords.contains(playerCoords)) {
            this.vampireCoords.remove(playerCoords);
            this.vampires--;
        }
    }
    
}
