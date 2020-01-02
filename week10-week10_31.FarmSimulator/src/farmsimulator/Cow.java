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
import java.util.Random;
import java.util.Arrays;

public class Cow implements Milkable, Alive {
    private String name;
    private Random random = new Random();
    private double capacity = this.random.nextDouble() * 25 + 15;
    private double milk = 0.0;
    private static final String[] NAMES = new String[]{"Anu", "Arpa", "Essi", "Heluna", 
        "Hely", "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki", "Mainikki", "Mella", 
        "Mimmi", "Naatti", "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Cow(String name) {
        this.name = name;
    }
    
    public Cow() {
        int nameNum = this.random.nextInt(this.NAMES.length);
        this.name = this.NAMES[nameNum];
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getAmount() {
        return this.milk;
    }
    
    public double milk() {
        double val = this.milk;
        this.milk = 0;
        return val;
    }
    
    public void liveHour() {
        double newAmount = this.random.nextDouble() * 1.3 + 0.7;
        this.milk = Math.min(this.milk + newAmount, this.capacity);
    }
    
    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.milk) + "/" + Math.ceil(this.capacity);
    }
}
