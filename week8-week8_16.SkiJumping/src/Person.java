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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Person implements Comparable<Person> {
    private String name;
    private ArrayList<Jump> jumps;
    private Random random;
    private int numScores;
    
    public Person(String name) {
        this.name = name;
        this.jumps = new ArrayList<Jump>();
        this.random = new Random();
        this.numScores = 5;
    }
    
    public int totalPoints() {
        int total = 0;
        int[] scores; 
        for (Jump jump:this.jumps) {
            total += jump.getDistance();
            scores = jump.getScores();
            Arrays.sort(scores);
            for (int i=1; i<this.numScores-1; i++) {
                total += scores[i];
            }
        }
        return total;
    }
    
    @Override
    public String toString() {
        return this.name + " (" + totalPoints() + " points)";
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<Jump> getJumps() {
        return this.jumps;
    }
    
    public int getDistance(int roundNum) {
        return this.jumps.get(roundNum).getDistance();
    }
    
    public int[] getScores(int roundNum) {
        return this.jumps.get(roundNum).getScores();
    }
    
    public void jump() {
        int distance = 60 + this.random.nextInt(60);
        int[] scores = new int[this.numScores];
        for (int i=0; i<this.numScores; i++) {
            scores[i] = 10 + random.nextInt(10);
        }
        
        this.jumps.add(new Jump(distance, scores));
    }
    
    @Override
    public int compareTo(Person person) {
        return this.totalPoints() - person.totalPoints();
        }
}
