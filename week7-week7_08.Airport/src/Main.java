import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        Scanner reader = new Scanner(System.in);
        DB db = new DB(reader);
        UI ui = new UI(db, reader);
        ui.startAirportPanel();
        ui.startFlightService();
    }
}
