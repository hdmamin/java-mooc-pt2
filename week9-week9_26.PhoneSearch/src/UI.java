/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UI {
    private Directory directory;
    private Scanner reader;
    
    public UI(Directory directory) {
        this.directory = directory;
        this.reader = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("phone search\n" +
                           "available operations:\n" +
                           " 1 add a number\n" +
                           " 2 search for a number\n" +
                           " 3 search for a person by phone number\n" +
                           " 4 add an address\n" +
                           " 5 search for personal information\n" +
                           " 6 delete personal information\n" +
                           " 7 filtered listing\n" +
                           " x quit");
        while (true) {
            System.out.println("\ncommand: ");
            String cmd = this.reader.nextLine();
            
            if (cmd.equals("x")) {
                break;
            } else if (cmd.equals("1")) {
                addNumber();
            } else if (cmd.equals("2")) {
                searchForNumber();
            } else if (cmd.equals("3")) {
                searchByNumber();
            } else if (cmd.equals("4")) {
                addAddress();
            } else if (cmd.equals("5")) {
                getPersonInfo();
            } else if (cmd.equals("6")) {
                deletePerson();
            } else if (cmd.equals("7")) {
                filteredListing();
            }
        }
    }
    
    public void addNumber() {
        System.out.println("whose number: ");
        String name = this.reader.nextLine();
        System.out.println("number: ");
        String number = this.reader.nextLine();
        
        this.directory.addPerson(name, number);
    }
    
    public void searchForNumber() {
        System.out.println("whose number: ");
        String name = this.reader.nextLine();
        List<String> numbers = this.directory.searchForNumber(name);
        
        for (String number:numbers) {
            System.out.println(" " + number);
        }
    }
    
    public void searchByNumber() {
        System.out.println("number: ");
        String number = this.reader.nextLine();
        String name = this.directory.searchByNumber(number);
        System.out.println(" " + name);
    }
    
    public void addAddress() {
        System.out.println("whose address: ");
        String name = this.reader.nextLine();
        System.out.println("street: ");
        String street = this.reader.nextLine();
        System.out.println("city: ");
        String city = this.reader.nextLine();
        this.directory.addAddress(name, street, city);
    }
    
    public void printPeople() {
        System.out.println(this.directory);
    }
    
    public void getPersonInfo() {
        System.out.println("whose information: ");
        String name = this.reader.nextLine();
        Person person = this.directory.getPerson(name);
        if (person == null) {
            System.out.println("  not found");
        } else {
            System.out.println(person);
        }
    }
    
    public void deletePerson() {
        System.out.println("whose information");
        String name = this.reader.nextLine();
        this.directory.deletePerson(name);
    }
    
    public void filteredListing() {
        System.out.println("keyword (if empty, all listed: ");
        String phrase = this.reader.nextLine();
        List<Person> people = this.directory.filterPeople(phrase);
        if (people.isEmpty()) {
            System.out.println(" keyword not found");
        } else {
            Collections.sort(people);
            for (Person person:people) {
                System.out.println(" " + person.getName());
                System.out.println(person);
            }
        }
    }
    
}
