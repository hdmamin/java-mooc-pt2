/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 *
 * @author hmamin
 */
public class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(Object object) {
        if (object.getClass() != getClass()) {
            return false;
        }
        
        Person person = (Person) object;
        return this.name.equals(person.getName());
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
}
