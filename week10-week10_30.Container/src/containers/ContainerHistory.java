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
import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {
    private List<Double> states;
    
    public ContainerHistory() {
        this.states = new ArrayList<Double>();
    }
    
    public void add(double state) {
        this.states.add(state);
    }
    
    public void reset() {
        this.states.clear();
    }
    
    public String toString() {
        return this.states.toString();
    }
    
    public double maxValue() {
        double max = Double.MIN_VALUE;
        for (double state:this.states) {
            if (state > max) {
                max = state;
            }
        }
        
        return max;
    }
    
    public double minValue() {
        double min = Double.MAX_VALUE;
        for (double state:this.states) {
            if (state < min) {
                min = state;
            }
        }
        
        return min;
    }
    
    public double average() {
        double total = 0;
        for (double state:this.states) {
            total += state;
        }
        
        return total / states.size();
    }
    
    public double greatestFluctuation() {
        if (this.states.size() <= 1) {
            return 0;
        }
        
        double prev = this.states.get(0);
        double curr;
        double maxDiff = 0;
        for (double state:this.states.subList(1, this.states.size())) {
            curr = state;
            maxDiff = Math.max(Math.abs(curr-prev), maxDiff);
            prev = curr;
        }
        
        return maxDiff;
    }
    
    public double variance() {
        if (this.states.size() <= 1) {
            return 0;
        }
        
        double sum = 0.0;
        double sumSquares = 0.0;
        double size = (double) this.states.size();
        
        for (double state:this.states) {
            sum += state;
            sumSquares += Math.pow(state, 2.0);
        }
        return (sumSquares / size - Math.pow(sum / size, 2)) * size / (size - 1);
    }
    
    public int numStates() {
        return this.states.size();
    }
    
    public List<Double> getStates() {
        return this.states;
    }
}
