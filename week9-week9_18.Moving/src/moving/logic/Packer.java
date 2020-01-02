/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Item;
import moving.domain.Thing;

public class Packer {
    private int boxVolume;
    
    public Packer(int boxVolume) {
        this.boxVolume = boxVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        Box box = new Box(this.boxVolume);
        boolean success = false;
        
        for (Thing thing:things) {
            success = box.addThing(thing);
            if (!success) {
                boxes.add(box);
                box = new Box(this.boxVolume);
                box.addThing(thing);
            }
            success = false;
        }
        
        // Add loast box;
        if (!success) {
            boxes.add(box);
        }
        
        return boxes;
    }
}
