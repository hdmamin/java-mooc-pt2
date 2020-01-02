/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private List<Movable> organisms;
    
    public Group() {
        this.organisms = new ArrayList<Movable>();
    }
    
    public void move(int dx, int dy) {
        for (Movable org:this.organisms) {
            org.move(dx, dy);
        }
    }
    
    public void addToGroup(Movable movable) {
        this.organisms.add(movable);
    }
    
    public String toString() {
        String output = "";
        for (Movable org:this.organisms) {
            output += org + "\n";
        }
        
        return output;
    }
    
}
