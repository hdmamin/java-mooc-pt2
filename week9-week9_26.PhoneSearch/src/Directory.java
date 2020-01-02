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
import java.util.HashMap;
import java.util.Map;

public class Directory {
    private Map<String, Person> people;
            
    public Directory() {
        this.people = new HashMap<String, Person>();
    }
    
    public void addPerson(String name, String number) {
        if (this.people.containsKey(name)) {
            Person person = this.people.get(name);
            person.addPhone(number);
        } else {
            Person person = new Person(name, number);
            this.people.put(name, person);
        }
    }
    
    public String toString() {
        String output = "";
        for (Person person:this.people.values()) {
            output += person;
        }
        
        return output;
    }
    
    public Map<String, Person> getPeople() {
        return this.people;
    }
    
    public List<String> searchForNumber(String name) {
        if (this.people.containsKey(name)) {
            return this.people.get(name).getPhones();
        } else {
            List<String> output = new ArrayList<String>();
            output.add("not found");
            return output;
        }
    }
    
    public String searchByNumber(String number) {
        for (Person person:this.people.values()) {
            if (person.getPhones().contains(number)) {
                return person.getName();
            }
        }
        
        return "not found";
    }
    
    public void addAddress(String name, String street, String city) {
        if (this.people.containsKey(name)) {
            this.people.get(name).addAddress(street, city);
        } else {
            Person person = new Person(name, street, city);
            this.people.put(name, person);
        }
    }
    
    public Person getPerson(String name) {
        return this.people.get(name);
    }
    
    public void deletePerson(String name) {
        this.people.remove(name);
    }
    
    public List<Person> filterPeople(String phrase) {
        List<Person> people = new ArrayList<Person>();
        for (Person person:this.people.values()) {
            if (person.getName().contains(phrase)) {
                people.add(person);
            } else {
                for (String address:person.getAddresses()) {
                    if (address.contains(phrase)) {
                        people.add(person);
                        break;
                    }
                }
            }
        }
        
        return people;
    }
}
