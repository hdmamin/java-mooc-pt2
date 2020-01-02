/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.Map;
import java.util.HashMap;

public class ShoppingBasket {
    private Map<String, Purchase> products;
    
    public ShoppingBasket() {
        this.products = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price) {
        if (this.products.containsKey(product)) {
            this.products.get(product).increaseAmount();
        } else {
            this.products.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int price = 0;
        for (Purchase product:this.products.values()) {
            price += product.price();
        }
        
        return price;
    }
    
    public void print() {
        for (Purchase product:this.products.values()) {
            System.out.println(product);
        }
    }
}
