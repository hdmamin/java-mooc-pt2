/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start() {
        while (true) {
            System.out.println("Satement: ");
            String cmd = this.reader.nextLine();
            if (cmd.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (cmd.equals("add")) {
                add();
            } else if (cmd.equals("translate")) {
                String translation = translate();
                System.out.println("Trnaslation: " + translation);
            }
        }
    }
    
    public void add() {
        System.out.println("In Finnish: ");
        String word = this.reader.nextLine();
        System.out.println("Translation: ");
        String trans = this.reader.nextLine();
        this.dictionary.add(word, trans);
    }
    
    public String translate() {
        System.out.println("Give a word: "); 
        String word = this.reader.nextLine();
        return this.dictionary.translate(word);
    }
}
