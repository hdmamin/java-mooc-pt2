/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author hmamin
 */
public class BulkTank {
    private double capacity;
    private double volume;
    
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0.0;
    }
    
    public BulkTank() {
        this(2000.0);
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getVolume() {
        return this.volume;
    }
    
    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount) {
        this.volume += Math.min(howMuchFreeSpace(), amount);
    }
    
    public double getFromTank(double amount) {
        double taken = Math.min(amount, getVolume());
        this.volume -= taken;
        return taken;
    }
    
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
