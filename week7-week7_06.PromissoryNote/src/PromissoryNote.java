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

public class PromissoryNote {
    private HashMap<String, Double> loans;
    
    public PromissoryNote() {
        this.loans = new HashMap<String, Double>();
    }
    
    public void setLoan(String toPerson, double value) {
     this.loans.put(toPerson, value);
    }
    
    public double howMuchIsTheDebt(String person) {
        if (this.loans.containsKey(person)) {
            return this.loans.get(person);
        }
        return 0.0;
    }
}
