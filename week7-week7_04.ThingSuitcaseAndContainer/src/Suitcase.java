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
        
public class Suitcase {
    private ArrayList<Thing> things;
    private int weightLimit;
    private int currWeight;
//    private Thing heaviest;
    
    public Suitcase(int weight) {
        this.things = new ArrayList<Thing>();
        this.weightLimit = weight;
        this.currWeight = 0;
    }
    
    public void addThing(Thing thing) {
        if (this.weightLimit - this.currWeight >= thing.getWeight()) {
            this.things.add(thing);
            this.currWeight += thing.getWeight();
            
//            if (this.heaviest == null || thing.getWeight() > this.heaviest.getWeight()) {
//                this.heaviest = thing;
//            }
        }
    }
    
    public int totalWeight() {
        return this.currWeight;
    }
    
//    public Thing heaviestThing() {
//        return this.heaviest;
//    }
    
    public Thing heaviestThing() {
        int maxWeight = Integer.MIN_VALUE;
        Thing heaviest = null;
        for (Thing thing:this.things) {
            if (thing.getWeight() > maxWeight) {
                maxWeight = thing.getWeight();
                heaviest = thing;
            }
        }
        return heaviest;
    }
    
    public void printThings() {
        for (Thing thing:this.things) {
            System.out.println(thing);
        }
    }
    
    public String toString() {
        String output = "";
        int numThings = this.things.size();
        if (numThings == 0) {
            output += "empty";
        } else if (numThings == 1) {
            output += "1 thing";
        } else {
            output += numThings + " things";
        }
        
        return output + "(" + this.currWeight + "kg)";
    }
    
}
