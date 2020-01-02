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
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Contest {
    private Scanner reader;
    private ArrayList<Person> people;
    
    public Contest() {
        this.reader = new Scanner(System.in);
        this.people = new ArrayList<Person>();
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("\nWrite the names of the participants one at a time; "
                           + "an empty string brings you to the jumping phase.\n");
        while (true) {
            System.out.println("  Participant name: ");
            String name = reader.nextLine();
            
            if (name.isEmpty()) {
                System.out.println("The tournament begins!\n");
                break;
            } else {
                addPerson(name);
            }
        }
        
        startContest();
    }
    
    public void startContest() {
        int round = 1;
        while (true) {
            System.out.println("Write \"jump\" to jump; otherwise you quit: ");
            String cmd = this.reader.nextLine();
            if (cmd.equals("jump")) {
                System.out.println("Round " + round);
                printJumpOrder();
                
                simulateJumps();
                printRoundResults(round - 1);
                round++;
            } else {
                System.out.println("\nThanks!");
                break;
            }
        }
        
        printResults();
    }
    
    public void simulateJumps() {
        for (Person person:this.people) {
            person.jump();
        }
    }
    
    public void addPerson(String name) {
        this.people.add(new Person(name));
    }
    
    
    public void printRoundResults(int roundNum) {
        System.out.println("Results of round " + (roundNum+1));
        for (Person person:this.people) {
            System.out.println("  " + person.getName());
            System.out.println("    length: " + person.getDistance(roundNum));
            System.out.print("    judge votes: [");
            int[] scores = person.getScores(roundNum);
            int length = scores.length;
            for (int i=0; i<length; i++) {
                System.out.print(scores[i]);
                if (i != length-1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]\n");
        }
    }
    
    public void printJumpOrder() {
        System.out.println("\nJumping order:");
        Collections.sort(this.people);
        for (int i=0; i<this.people.size(); i++) {
            System.out.print("  " + (i+1) + ". ");
            System.out.println(this.people.get(i));
        }
    }
    
    public void printResults() {
        System.out.println("\nTournament results:");
        System.out.println("Position    Name");
        Collections.sort(this.people, Collections.reverseOrder());

        for (int i=0; i<this.people.size(); i++) {
            Person person = this.people.get(i);
            System.out.print((i+1) + "           ");
            System.out.println(person);
            System.out.print("            jump lengths: ");
            
            ArrayList<Jump> jumps = person.getJumps();
            int numJumps = jumps.size();
            for (int j=0; j<numJumps; j++) {
                System.out.print(jumps.get(j).getDistance() + " m");
                if (j != numJumps-1) {
                    System.out.print(", ");
                } else {
                    System.out.println("");
                }
            }
        }
    }
}
