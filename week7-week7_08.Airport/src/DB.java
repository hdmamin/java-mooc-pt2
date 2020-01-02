/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DB {
    private HashMap<String, Plane> planes;
    private ArrayList<Flight> flights;
    
    public DB(Scanner reader) {
        this.planes = new HashMap<String, Plane>();
        this.flights = new ArrayList<Flight>();
    }
    
    public void addPlane(String name, int capacity) {
        this.planes.put(name, new Plane(name, capacity));
    }
    
    public void addFlight(String from, String to, Plane plane) {
        this.flights.add(new Flight(from, to, plane));
    }
    
    public Plane getPlane(String name) {
        if (this.planes.containsKey(name)) {
            return this.planes.get(name);
        }
        
        return null;
    }
    
    public HashMap<String, Plane> getPlanes() {
        return this.planes;
    }
    
    public ArrayList<Flight> getFlights() {
        return this.flights;
    }
}
