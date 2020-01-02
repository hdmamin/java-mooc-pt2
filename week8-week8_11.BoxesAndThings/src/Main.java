/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
public class Main {
    
    public static void main(String[] args) {
        Box box = new Box(10);
        box.add(new Book("JK Rowling", "Harry Potter", 16.0));
        box.add(new CD("Kid Cudi", "Man on the Moon", 2004));
        box.add(new Book("JRR Tolkien", "LOTR", 4.5));
        
        System.out.println(box);
        
        Box bigBox = new Box(15);
        bigBox.add(box);
        System.out.println(bigBox);
    }
    
}
