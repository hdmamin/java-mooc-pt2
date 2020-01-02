/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
public class Purchase {
    private String name;
    private int amount;
    private int unitPrice;
    
    public Purchase(String name, int amount, int unitPrice) {
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return this.amount * this.unitPrice;
    }
    
    public void increaseAmount() {
        this.amount++;
    }
    
    public String toString() {
        return this.name + ": " + this.amount;
    }
}
