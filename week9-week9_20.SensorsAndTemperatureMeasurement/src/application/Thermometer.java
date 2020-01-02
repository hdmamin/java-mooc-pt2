/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author hmamin
 */
import java.lang.IllegalStateException;
import java.util.Random;

public class Thermometer implements Sensor {
    private Random random;
    private boolean on;
    
    public Thermometer() {
        this.random = new Random();
        this.on = false;
    }

    public void on() {
        this.on = true;
    }
    
    public void off() {
        this.on = false;
    }
    
    public boolean isOn() {
        return this.on;
    }
    
    public int measure() {
        if (this.on) {
            return this.random.nextInt(60) - 30;
        } else {
            throw new IllegalStateException("Thermometer is off.");
        }
    }
    
}
