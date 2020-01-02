/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logic;

import mooc.ui.UserInterface;
/**
 *
 * @author hmamin
 */
public class ApplicationLogic {
    private UserInterface ui;
    
    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }
    
    public void execute(int numTimes) {
        for (int i=0; i<numTimes; i++) {
            System.out.println("The application logic works.");
            this.ui.update();
        }
    } 
            
}
