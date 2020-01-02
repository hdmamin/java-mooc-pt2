/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
public class Flight {
    private String fromPort;
    private String toPort;
    private Plane plane;
    
    public Flight(String fromPort, String toPort, Plane plane) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.plane = plane;
    }
    
    public String toString() {
        return plane + " (" + this.fromPort + "-" + this.toPort + ")";
    }
}
