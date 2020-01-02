/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;

public class Changer {
    private ArrayList<Change> changers;
    
    public Changer() {
        this.changers = new ArrayList<Change>();
    }
    
    public void addChange(Change change) {
        this.changers.add(change);
    }
    
    public String change(String word) {
        for (Change change:this.changers) {
            word = change.change(word);
        }
        
        return word;
    }
    
}
