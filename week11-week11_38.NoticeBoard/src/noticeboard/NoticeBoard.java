package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 250));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        // Create components.
        JTextField text1 = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel text2 = new JLabel();
        
        // Listen for button click.
        TextCopier copier = new TextCopier(text1, text2);
        button.addActionListener(copier);
                
        // Add components to frame.
        container.add(text1);
        container.add(button);
        container.add(text2);
    }
}
