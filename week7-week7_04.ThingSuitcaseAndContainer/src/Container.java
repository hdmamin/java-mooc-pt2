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

public class Container {
    private int maxWeight;
    private int totalWeight;
    private ArrayList<Suitcase> suitcases;
    
    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if (this.maxWeight - this.totalWeight >= suitcase.totalWeight()) {
            this.suitcases.add(suitcase);
            this.totalWeight += suitcase.totalWeight();
        }
    }
    
    public String toString() {
        return this.suitcases.size() + " suitcases (" + this.totalWeight + " kg)";
    }
    
    public void printThings() {
        for (Suitcase sc:this.suitcases) {
            sc.printThings();
        }
    }
}
