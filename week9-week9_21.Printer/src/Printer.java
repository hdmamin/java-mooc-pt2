/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Printer {
    private String fname;
    private Scanner reader;
    private ArrayList<String> lines;
    
    public Printer(String fname) {
        this.fname = fname;
        
        try {
            this.reader = new Scanner(new File(fname), "UTF-8");
        } catch (Exception e) {
            System.out.println("File not found.");
            return;
        }
        
        this.lines = readLines();
    }
    
    public ArrayList<String> readLines() {
        ArrayList<String> lines = new ArrayList<String>();
        
        while (this.reader.hasNextLine()) {
            lines.add(this.reader.nextLine());
        }
        
        return lines;
    }
    
    public void printLinesWhichContain(String word) {
//        while (this.reader.hasNextLine()) {
//            String line = this.reader.nextLine();
//            if (line.contains(word)) {
//                System.out.println(line);
//            }
//        }

        for (String line:this.lines) {
            if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }
}
