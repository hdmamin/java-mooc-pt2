/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
public class Calculator {
    private Reader reader;
    private int calcs;
    
    public Calculator() {
        this.reader = new Reader();
        this.calcs = 0;
    }
    
    public void start() {
        while (true) {
            System.out.println("command:");
            String cmd = this.reader.readString();
            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("sum")) {
                sum();
            } else if (cmd.equals("difference")) {
                difference();   
            } else if (cmd.equals("product")) {
                product();
            }
        }
        
        statistics();
    }
    
    public int [] loadInput() {
        int[] output = new int[2];
        System.out.println("value1: ");
        output[0] = reader.readInt();
        System.out.println("value2: ");
        output[1] = reader.readInt();
        return output;
    }
    
    private void sum() {
        int[] data = loadInput();
        System.out.println("sum of the values " + (data[0] + data[1]));
        this.calcs++;
    }
    
    private void difference() {
        int[] data = loadInput();
        System.out.println("difference of the values " + (data[0] - data[1]));
        this.calcs++;
    }
    
    private void product() {
        int[] data = loadInput();
        System.out.println("product of the values " + (data[0] * data[1]));
        this.calcs++;
    }
    
    private void statistics() {
        System.out.println("Calculations done " + this.calcs);
    }
    
}
