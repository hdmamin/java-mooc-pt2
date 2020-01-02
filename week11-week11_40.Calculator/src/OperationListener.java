/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.IllegalArgumentException;
import javax.swing.JButton;
import javax.swing.JTextField;
/**
 *
 * @author hmamin
 */
public class OperationListener implements ActionListener {
    private JButton btn;
    private JTextField inputField;
    private JTextField outputField;
    private String operation;
    
    public OperationListener(JButton resetBtn, JTextField inputField, JTextField outputField, String operation) {
        this.btn = resetBtn;
        this.inputField = inputField;
        this.outputField = outputField;
        this.operation = operation;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        int currVal = Integer.parseInt(this.outputField.getText());
        int newVal = 0;
        
        // Handle invalid input.
        if (this.operation != "reset") {
            try {
                newVal = Integer.parseInt(this.inputField.getText());
            } catch (Exception e) {
                System.out.println("Invalid or missing input."); 
            }
        }
        
        // Perform specified operation.
        if (this.operation.equals("add")) {
            currVal += newVal;
        } else if (this.operation.equals("subtract")) {
            currVal -= newVal;
        } else if (this.operation.equals("reset")) {
            currVal = 0;
        }
        
        // Update text fields.
        this.outputField.setText("" + currVal);
        this.inputField.setText("");
        
        // Enable/disable reset button depending on output value.
        if (this.outputField.getText().equals("0")) {
            this.btn.setEnabled(false);
            System.out.println(this.outputField.getText());
        } else {
            System.out.println("\ncase2");
            System.out.println(this.outputField.getText());
            System.out.println(this.outputField.getText().getClass());
            System.out.println(this.outputField.getText().equals("0"));
            this.btn.setEnabled(true);
        }
    }
}
