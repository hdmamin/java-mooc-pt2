package movingfigure;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // test your program here
//        UserInterface ui = new UserInterface(new Circle(50, 50, 100));
//        UserInterface ui = new UserInterface(new Square(20, 20, 100));
        CompoundFigure truck = new CompoundFigure();
        truck.add(new Box(220, 110, 75, 100));
        truck.add(new Box(80, 120, 200, 100));
        truck.add(new Circle(100, 200, 50));
        truck.add(new Circle(200, 200, 50));
        
        UserInterface ui = new UserInterface(truck);
        SwingUtilities.invokeLater(ui);
    }
}
