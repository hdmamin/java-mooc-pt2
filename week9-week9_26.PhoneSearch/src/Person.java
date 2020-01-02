/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.List;
import java.util.ArrayList;

public class Person implements Comparable<Person> {
    private String name;
    private List<String> phones;
    private List<String> addresses;
    
    public Person(String name, String phone, String street, String city) {
        this.name = name;
        this.phones = new ArrayList<String>();
        this.addresses = new ArrayList<String>();
    
        if (phone != null) {
            this.phones.add(phone);
        }
        
        if (street != null & city != null) {
            this.addresses.add(street + city);
        }
    }

    public Person(String name, String phone) {
        this(name, phone, null, null);
    }
    
    public Person(String name, String street, String city) {
        this(name, null, street, city);
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<String> getPhones() {
        return this.phones;
    }
    
    public List<String> getAddresses() {
        return this.addresses;
    }
    
    public void addPhone(String number) {
        this.phones.add(number);
    }
    
    public String toString() {
        String output = "\n  address";
        
        if (this.addresses.isEmpty()) {
            output += " unknown\n";
        } else {
            output += ": ";
            for (String address:this.addresses) {
                output += address + "\n";
            }
        }
        
        output += "  phone number";
        if (this.phones.isEmpty()) {
            output += " not found";
        } else {
            output += "s:";
            for (String phone:this.phones) {
                output += "\n   " + phone;
            }
        }
        
        return output;
    }
    
    public void addAddress(String street, String city) {
        this.addresses.add(street+city);
    }
    
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        
        Person person = (Person) obj;
        return this.name.equals(person.getName());
    }
    
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

}
