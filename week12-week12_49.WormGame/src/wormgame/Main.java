package wormgame;

import javax.swing.SwingUtilities;
import wormgame.gui.UserInterface;
import wormgame.game.WormGame;
import wormgame.domain.Worm;

public class Main {

    public static void main(String[] args) {
        // Testing code from ex 49.2
//        Worm worm = new Worm(5, 5, Direction.RIGHT);
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//
//        worm.grow();
//        System.out.println(worm.getPieces());
//        worm.move();
//        System.out.println(worm.getPieces());
//
//        worm.setDirection(Direction.LEFT);
//        System.out.println(worm.runsIntoItself());
//        worm.move();
//        System.out.println(worm.runsIntoItself());
        

        WormGame game = new WormGame(20, 20);

        UserInterface ui = new UserInterface(game, 20);
        SwingUtilities.invokeLater(ui);

        while (ui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("The drawing board hasn't been created yet.");
            }
        }

        game.setUpdatable(ui.getUpdatable());
        game.start();
    }
}
