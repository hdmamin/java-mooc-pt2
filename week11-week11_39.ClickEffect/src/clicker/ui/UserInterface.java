package clicker.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import clicker.applicationlogic.PersonalCalculator;

public class UserInterface implements Runnable {
    private JFrame frame;


    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        JLabel label = new JLabel("0");
        JButton btn = new JButton("Click!");
        
        ClickListener listener = new ClickListener(new PersonalCalculator(), label);
        btn.addActionListener(listener);
        
        container.add(label);
        container.add(btn);
    }

    public JFrame getFrame() {
        return frame;
    }
}
