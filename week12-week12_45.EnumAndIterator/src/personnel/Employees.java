/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author hmamin
 */
public class Employees {
    private List<Person> people;
    
    public Employees() {
        this.people = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        this.people.add(person);
    }
    
    public void add(List<Person> newPeople) {
        for (Person person:newPeople) {
            add(person);
        }
    }
    
    public void print() {
        for (Person person:this.people) {
            System.out.println(person);
        }
    }
    
    public void print(Education education) {
        Iterator<Person> peopleIter = this.people.iterator();
        
        while (peopleIter.hasNext()) {
            Person person = peopleIter.next();
            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> peopleIter = this.people.iterator();
        
        while (peopleIter.hasNext()) {
            Person person = peopleIter.next();
            if (person.getEducation() == education) {
                peopleIter.remove();
            }
        }
    }
}
