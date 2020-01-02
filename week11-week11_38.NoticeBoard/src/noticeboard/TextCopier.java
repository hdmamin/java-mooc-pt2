/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 *
 * @author hmamin
 */
public class TextCopier implements ActionListener {
    private JTextField fromArea;
    private JLabel toArea;
    
    public TextCopier(JTextField fromArea, JLabel toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.toArea.setText(this.fromArea.getText());
        this.fromArea.setText("");
    }
    
    
}
