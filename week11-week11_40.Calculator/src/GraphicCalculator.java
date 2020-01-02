
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 250));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        // Row 1
        JTextField textOut = new JTextField();
        textOut.setText("0");
        textOut.setEnabled(false);
        textOut.setPreferredSize(new Dimension(400, 50));

        // Row 2
        JTextField textIn = new JTextField();
        
        // Row 3
        JPanel panel = createPanel(textIn, textOut);
        
        container.add(textOut);
        container.add(textIn);
        container.add(panel);
        
//        container.add(textOut, BorderLayout.NORTH);
//        container.add(textIn);
//        container.add(panel, BorderLayout.SOUTH);
    }

    public JPanel createPanel(JTextField textIn, JTextField textOut) {
        // Row 3
        GridLayout layout = new GridLayout(1, 3);        
        JPanel panel = new JPanel(layout);
        panel.setPreferredSize(new Dimension(400, 50));

        // Reset button
        JButton resetBtn = new JButton("Z");
        resetBtn.addActionListener(new OperationListener(resetBtn, textIn, textOut, "reset"));
        
        // Addition button
        JButton addBtn = new JButton("+");
        addBtn.addActionListener(new OperationListener(resetBtn, textIn, textOut, "add"));
        panel.add(addBtn);
        
        // Subtraction button
        JButton subBtn = new JButton("-");
        subBtn.addActionListener(new OperationListener(resetBtn, textIn, textOut, "subtract"));
        panel.add(subBtn);
        
        
        // Disable reset button if output is 0.
        if (textOut.getText().equals("0")) {
            resetBtn.setEnabled(false);
        } else {
            resetBtn.setEnabled(true);
        }
        panel.add(resetBtn);
        
        return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
