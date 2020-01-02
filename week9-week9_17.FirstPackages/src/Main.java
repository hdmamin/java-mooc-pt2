/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import mooc.logic.ApplicationLogic;
import mooc.ui.TextUserInterface;

public class Main {
    
    public static void main(String[] args) {
        TextUserInterface ui = new TextUserInterface();
        ApplicationLogic app = new ApplicationLogic(ui);
        app.execute(4);
    }
}
