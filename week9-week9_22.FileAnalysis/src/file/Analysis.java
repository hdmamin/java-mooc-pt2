/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author hmamin
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Analysis {
    private File file;
    private ArrayList<String> lines;
    
    public Analysis(File file) {
        this.file = file;
        this.lines = readLines();
    }
    
    public ArrayList<String> readLines() {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner reader = null;

        try {
            reader = new Scanner(this.file, "UTF-8");
        } catch (Exception e) {
            System.out.println("Error reading file.");
            return lines;
        }
        
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine() + "\n");
        }
        
        return lines;
    }
    
    public int lines() {
        return this.lines.size();
    }
    
    public int characters() {
        int total = 0;
        for (String line:this.lines) {
            total += line.length();
        }
        
        return total;
    }
}
