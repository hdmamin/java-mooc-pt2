/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author hmamin
 */
import java.util.List;

public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory history;
    
    public ProductContainerRecorder(String name, double capacity, double initialVol) {
        super(name, capacity);
        this.history = new ContainerHistory();
        addToTheContainer(initialVol);
//        this.history.add(getVolume());
    }
    
    public String history() {
        return this.history.toString();
    }
    
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        this.history.add(getVolume());
    }
    
    public double takeFromTheContainer(double amount) {
        super.takeFromTheContainer(amount);
        this.history.add(getVolume());
        List<Double> states = this.history.getStates();
        int size = states.size();
        return states.get(size-2) - getVolume();
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + this.history.maxValue());
        System.out.println("Smallest product amount: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
        System.out.println("Greatest change: " + this.history.greatestFluctuation());
        System.out.println("Variance: " + this.history.variance());
    }
}
