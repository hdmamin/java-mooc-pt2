
public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        Directory directory = new Directory();
        UI ui = new UI(directory);
        ui.start();
        
    }
}
