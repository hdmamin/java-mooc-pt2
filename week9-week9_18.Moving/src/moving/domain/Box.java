/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;

public class Box implements Thing {
    private int capacity;
    private ArrayList<Thing> things;
    
    public Box(int capacity) {
        this.capacity = capacity;
        this.things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (getVolume() + thing.getVolume() <= this.capacity) {
            this.things.add(thing);
            return true;
        }
        
        return false;
    }
    
    public int getVolume() {
        int total = 0;
        for (Thing thing:this.things) {
            total += thing.getVolume();
        }
        
        return total;
    }
    
    public String toString() {
        return "Box(capacity=" + this.capacity + ", volume=" + this.getVolume() + ")";
    }
    
}
