/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {
    private List<Cow> cows;
    private Barn barn;
    private String owner;
    
    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public String getOwner() {
        return this.owner;
    }

    public void addCow(Cow cow) {
        this.cows.add(cow);
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }
    
    public void liveHour() {
        for (Cow cow:this.cows) {
            cow.liveHour();
        }
    }
    
    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }
    
    @Override
    public String toString() {
        String output = "Farm owner: " + this.owner + "\nBarn bulk tank: " + 
                this.barn + "\nAnimals";
        
        for (Cow cow:this.cows) {
            output += cow;
        }
        
        return output;
    }
}
