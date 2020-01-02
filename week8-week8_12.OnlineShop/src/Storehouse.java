/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> name2price;
    private Map<String, Integer> name2stock;
    
    public Storehouse() {
        this.name2price = new HashMap<String, Integer>();
        this.name2stock = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.name2price.put(product, price);
        this.name2stock.put(product, stock);
    }
    
    public int price(String product) {
        if (this.name2price.containsKey(product)) {
            return this.name2price.get(product);            
        }
        
        return -99;
    }
    
    public int stock(String product) {
        if (this.name2stock.containsKey(product)) {
            return this.name2stock.get(product);
        }
        
        return 0;
    }
    
    public boolean take(String product) {
        if (this.name2stock.containsKey(product) && this.name2stock.get(product) > 0) {
            this.name2stock.put(product, this.name2stock.get(product) - 1);
            return true;
        }
        
        return false;
    }
    
    public Set<String> products() {
        return this.name2price.keySet();
    }
}
