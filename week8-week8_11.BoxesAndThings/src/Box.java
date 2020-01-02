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

public class Box implements ToBeStored {
    private double weightLimit;
    private ArrayList<ToBeStored> contents;
    
    public Box(double weightLimit) {
        this.weightLimit = weightLimit;
        this.contents = new ArrayList<ToBeStored>();
    }
    
    public double weight() {
        double weight = 0.0;
        for (ToBeStored item:this.contents) {
            weight += item.weight();
        }
        
        return weight;
    }
    
    public void add(ToBeStored obj) {
        if (weight() + obj.weight() <= this.weightLimit) {
            this.contents.add(obj);
        }
    }
    
    @Override
    public String toString() {
        return "Box: " + this.contents.size() + " things, total weight " + weight() + " kg";
    }
}
