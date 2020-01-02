/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
public class Main {
    
    public static void main(String[] args) {
        RingingCentre centre = new RingingCentre();
        centre.observe(new Bird("blue jay", "habeas corpus", 1999), "San Francisco");
        centre.observe(new Bird("raven", "et tu", 2004), "Atlanta");
        centre.observe(new Bird("raven", "et tu", 2009), "Chicago");
        centre.observations(new Bird("raven", "et tu", 1900));
    }
}
