/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import clicker.applicationlogic.Calculator;
import javax.swing.JTextField;
/**
 *
 * @author hmamin
 */
public class ClickListener implements ActionListener {
    private Calculator calc;
    private JLabel label;
    
    public ClickListener(Calculator calc, JLabel label) {
        this.calc = calc;
        this.label = label;
    }
    
    public void actionPerformed(ActionEvent e) {
        this.calc.increase();
        this.label.setText("" + this.calc.giveValue());
    }
}
