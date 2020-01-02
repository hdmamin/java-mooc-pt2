/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;

/**
 *
 * @author hmamin
 */
public class Square extends Figure {
    private int width;
           
    public Square(int x, int y, int width) {
        super(x, y);
        this.width = width;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(getX(), getY(), this.width, this.width);
    }
}
