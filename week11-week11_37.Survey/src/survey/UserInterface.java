package survey;



import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JLabel question1 = new JLabel("Are you?");
        JCheckBox answer1 = new JCheckBox("Yes!");
        JCheckBox answer2 = new JCheckBox("No!");

        JLabel question2 = new JLabel("Why?");
        JRadioButton answer3 = new JRadioButton("No reason.");
        JRadioButton answer4 = new JRadioButton("Because it is fun!");
        
        JButton button = new JButton("Done!");
                
        // Ensure question 2 only allows single answer selection.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(answer3);
        buttonGroup.add(answer4);
        
        // Question 1
        container.add(question1);
        container.add(answer1);
        container.add(answer2);
        
        // Question 2
        container.add(question2);
        container.add(answer3);
        container.add(answer4);
        container.add(button);
    }

    public JFrame getFrame() {
        return frame;
    }
}
