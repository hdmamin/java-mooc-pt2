/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author hmamin
 */
public class CompoundFigure extends Figure {
    private List<Figure> figures;
    
    public CompoundFigure() {
        super(0, 0);
        this.figures = new ArrayList<Figure>();
    }

    
    public void add(Figure figure) {
        this.figures.add(figure);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Figure figure:this.figures) {
            figure.move(dx, dy);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure figure:this.figures) {
            figure.draw(graphics);
        }
    }
}
