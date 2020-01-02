/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;
/**
 *
 * @author hmamin
 */
public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> people;
    
    public PersonComparator(Map<Person, Integer> people) {
        this.people = people;
    }
    
    public int compare(Person person1, Person person2) {
        // Sort by person's number descending.
        return this.people.getOrDefault(person2, 0) - this.people.getOrDefault(person1, 0);
    }
}
