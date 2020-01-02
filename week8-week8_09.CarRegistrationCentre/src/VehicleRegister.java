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

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (!this.owners.containsKey(plate)) {
            this.owners.put(plate, owner);
            return true;
        }
        
        return false;
    }
    
    public String get(RegistrationPlate plate) {
        if (this.owners.containsKey(plate)) {
            return this.owners.get(plate);
        }
        
        return null;
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (this.owners.containsKey(plate)) {
            this.owners.remove(plate);
            return true;
        }
        
        return false;
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate:this.owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        HashMap<String, Boolean> printed = new HashMap<String, Boolean>();
        for (String owner:this.owners.values()) {
            if (!printed.containsKey(owner)) {
                System.out.println(owner);
                printed.put(owner, true);
            }
        }
    }
}
