/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.Scanner;

public class UI {
    private DB db;
    private Scanner reader;
    
    public UI(DB db, Scanner reader) {
        this.db = db;
        this.reader = reader;
    }
    
    public void startAirportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            String cmd = this.reader.nextLine();
            
            // Process user input.
            if (cmd.equals("1")) {
                addPlane();
            } else if (cmd.equals("2")) {
                addFlight();
            } else if (cmd.equals("x")) {
                break;
            }
        }
    }
    
    public void startFlightService() {
        while (true) {
            System.out.println("Flight service");
            System.out.println("------------");
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            String cmd = this.reader.nextLine();

            // Process user input.
            if (cmd.equals("x")) {
                break;
            } else if (cmd.equals("1")) {
                printPlanes();
            } else if (cmd.equals("2")) {
                printFlights();
            } else if (cmd.equals("3")) {
                printPlaneInfo();
            }
        }
        
    }
    
    public void addPlane() {
        System.out.println("Give plane ID: ");
        String name = this.reader.nextLine();
        System.out.println("Give plane capacity: ");
        int capacity = Integer.parseInt(this.reader.nextLine());
        this.db.addPlane(name, capacity);
    }
    
    public void addFlight() {
        System.out.println("Give plane ID: ");
        String name = this.reader.nextLine();
        System.out.println("Give departure airport code: ");
        String from = this.reader.nextLine();
        System.out.println("Give destination airport code: ");
        String to = this.reader.nextLine();
        Plane plane = this.db.getPlane(name);
        this.db.addFlight(from, to, plane);
    }
    
    public void printPlanes() {
        for (Plane plane:this.db.getPlanes().values()) {
            System.out.println(plane);
        }
    }
    
    public void printPlaneInfo() {
        System.out.println("Give plane ID: ");
        String name = this.reader.nextLine();
        Plane plane = this.db.getPlane(name);
        System.out.println(plane);
    }
    
    public void printFlights() {
        for (Flight flight:this.db.getFlights()) {
            System.out.println(flight);
        }
    }
    
}
