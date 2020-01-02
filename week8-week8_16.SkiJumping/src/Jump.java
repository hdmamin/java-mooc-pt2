/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.Arrays;

public class Jump {
    private int distance;
    private int[] scores;
    
    public Jump(int distance, int[] scores) {
        this.distance = distance;
        this.scores = scores;
    }
    
    public int getDistance() {
        return this.distance;
    }
    
    public int[] getScores() {
        return this.scores;
    }
    
}
