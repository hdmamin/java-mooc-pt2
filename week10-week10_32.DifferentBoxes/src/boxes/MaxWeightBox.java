/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> things;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }
    
    public int getWeight() {
        int total = 0;
        for (Thing thing:this.things) {
            total += thing.getWeight();
        }
        
        return total;
    }
    
    public void add(Thing thing) {
        if (getWeight() + thing.getWeight() <= this.maxWeight) {
            this.things.add(thing);
        }
    }
    
    public boolean isInTheBox(Thing thing) {
        return this.things.contains(thing);
    }
    
}
