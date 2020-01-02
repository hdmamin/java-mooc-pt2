package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.Direction;
import wormgame.gui.Updatable;
import wormgame.domain.Worm;

public class WormGame extends Timer implements ActionListener {
    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Random random;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.random = new Random();
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        
        // Randomly generate apple coords that don't intersect with worm.
        int appleX = width/2;
        int appleY = height/2;
        while (appleX == width/2 & appleY == height/2) {
            appleX = random.nextInt(width);
            appleY = random.nextInt(height);
        }
        this.apple = new Apple(appleX, appleY);

        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public Worm getWorm() {
        return this.worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }
    
    public Apple getApple() {
        return this.apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }

        this.worm.move();
        if (this.worm.runsInto(apple)) {
            this.worm.grow();
            setApple(new Apple(this.random.nextInt(this.width), this.random.nextInt(this.height)));
        }
        
        // Check if worm runs into self or wall.
        if (this.worm.runsIntoItself()) {
            continues = false;
        }
        
        for (Piece piece:this.worm.getPieces()) {
            if (piece.getX() > this.width - 1 | piece.getX() < 0 | 
                piece.getY() > this.height - 1 | piece.getY() < 0) {
                continues = false;
            }
        }
        
        updatable.update();
        setDelay(1000 / this.worm.getLength());
    }

}
