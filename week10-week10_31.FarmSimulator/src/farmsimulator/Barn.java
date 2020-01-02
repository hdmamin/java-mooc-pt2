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
import java.lang.IllegalStateException;
import java.util.Collection;

public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
    }
    
    public BulkTank getBulkTank() {
        return this.tank;
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        this.robot = robot;
        robot.setBulkTank(this.tank);
    }
    
    public void takeCareOf(Cow cow) {
        if (this.robot == null) {
            throw new IllegalStateException();
        }
        
        double amount = cow.milk();
        this.tank.addToTank(amount);
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for (Cow cow:cows) {
            takeCareOf(cow);
        }
    }
    
    public String toString() {
        return this.tank.toString();
    }
}
