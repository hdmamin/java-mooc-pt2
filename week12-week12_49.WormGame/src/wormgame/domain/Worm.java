/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;
/**
 *
 * @author hmamin
 */
public class Worm {
    private List<Piece> pieces;
    private Direction direction;
    private int startX;
    private int startY;
    private boolean needToGrow;
    
    public Worm(int startX, int startY, Direction startDirection) {
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(startX, startY));
        this.direction = startDirection;
        this.startX = startX;
        this.startY = startY;
        this.needToGrow = false;
    }
    
    public Direction getDirection() {
        return this.direction;
    }
    
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    public int getLength() {
        return this.pieces.size();
    }
    
    public List<Piece> getPieces() {
        return this.pieces;
    }
    
    public void move() {        
        // Move by adding to head and removing tail.
        if (getLength() >= 3 & !this.needToGrow) {
            this.pieces.remove(0);
        }
        this.needToGrow = true;
        grow();
    }
    
    public void grow() {
        if (!this.needToGrow) {
            this.needToGrow = true;
            return;
        }
        
        Piece last = this.pieces.get(this.pieces.size() - 1);
        int newX = last.getX();
        int newY = last.getY();
        
        if (this.direction == Direction.UP) {
            newY--;
        } else if (this.direction == Direction.DOWN) {
            newY++;
        } else if (this.direction == Direction.LEFT) {
            newX--;
        } else if (this.direction == Direction.RIGHT) {
            newX++;
        }
        
        this.pieces.add(new Piece(newX, newY));
        this.needToGrow = false;
    }
    
    public boolean runsInto(Piece newPiece) {
        // Check if any of worm's pieces run into new piece.
        for (Piece piece:this.pieces) {
            if (piece.runsInto(newPiece)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean runsIntoItself() {
        for (Piece piece1:this.pieces) {
            for (Piece piece2:this.pieces) {
                if (piece1 != piece2 & piece1.runsInto(piece2)) {
                    return true;
                }
            }
        }
        
        return false;
    }

}
