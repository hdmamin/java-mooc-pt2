package game;

import gameoflife.Simulator;

public class Main {

    public static void main(String[] args) {
        // test your program here
        PersonalBoard board = new PersonalBoard(3, 3);
        System.out.println(board.getHeight());
        System.out.println(board.getWidth());
        System.out.println("");
        
        board.turnToLiving(0, 0);
        board.turnToLiving(1, 0);
        int livingNeighbours = board.getNumberOfLivingNeighbours(1, 1);
        board.manageCell(1, 1, livingNeighbours);
        System.out.println(board.isAlive(1, 1));
        System.out.println(board);
    }
}
