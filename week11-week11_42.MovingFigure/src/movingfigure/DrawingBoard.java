/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 *
 * @author hmamin
 */
public class DrawingBoard extends JPanel {
    private Figure figure;
    
    public DrawingBoard(Figure figure) {
        super.setBackground(Color.WHITE);
        this.figure = figure;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.figure.draw(graphics);
    }
    
}
