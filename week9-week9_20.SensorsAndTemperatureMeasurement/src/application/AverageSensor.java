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
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public void on() {
        for (Sensor sensor:this.sensors) {
            sensor.on();
        }
    }

    public void off() {
        this.sensors.get(0).off();
    }
    
    public boolean isOn() {
        for (Sensor sensor:this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        
        return true;
    }

    public int measure() {
        if (!isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("Either no sensors are present, or not all are on.");
        }
        
        int total = 0;
        for (Sensor sensor:this.sensors) {
            total += sensor.measure();
        }
        
        // Integer division.
        int avg = total / this.sensors.size();
        this.readings.add(avg);
        return avg;
    }
    
    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }
    
    public List<Integer> readings() {
//        List<Integer> measures = new ArrayList<Integer>();
//        
//        for (Sensor sensor:this.sensors) {
//            measures.add(sensor.measure());
//        }
//        
//        return measures;
        return this.readings;
    }
}
