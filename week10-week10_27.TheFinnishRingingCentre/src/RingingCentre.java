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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RingingCentre {
    private Map<Bird, List<String>> birdToObs;
    
    public RingingCentre() {
        this.birdToObs = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place) {
        List<String> observed = new ArrayList<String>();
        observed.add(place);
        
        if (this.birdToObs.containsKey(bird)) {
            List<String> observations = this.birdToObs.get(bird);
            if (observations == null) {
                this.birdToObs.put(bird, observed);
            } else {
                observations.add(place);
            }
        } else {
            this.birdToObs.put(bird, observed);
        }
    }
    
    public void observations(Bird bird) {
        List<String> observations = null;
        int size = 0;
        if (this.birdToObs.containsKey(bird)) {
            observations = this.birdToObs.get(bird);
            size = observations.size();
        }
        
        System.out.println(bird + " observations: " + size);
        if (size > 0) {
            for (String place:observations) {
                System.out.println(place);
            }
        }
    }
}
