/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author hmamin
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MindfulDictionary {
    private Map<String, String> words;
    private String fileName;
    
    public MindfulDictionary() {
        this.words = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String fileName) {
        this();
        this.fileName = fileName;
    }
    
    public void add(String word, String trans) {
        if (!this.words.containsKey(word)) {
            this.words.put(word, trans);
        }
    }
    
    public String translate(String word) {
        String translation = this.words.get(word);
        
        if (translation == null) {
            for (String currWord:this.words.keySet()) {
                if (this.words.get(currWord).equals(word)) {
                    return currWord;
                }
            }
        }
            
        return translation;
    }
    
    public void remove(String word) {
        // Remove word from keys.
        this.words.remove(word);
        
        // Remove word from values.
        if (this.words.values().contains(word)) {
            for (String key:this.words.keySet()) {
                if (this.words.get(key).equals(word)) {
                    this.words.remove(key);
                    return;
                }
            }
        }
    }
    
    public boolean load() {
        try {
            Scanner reader = new Scanner(new File(this.fileName));

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(":");
                add(line[0], line[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean save() {
        try {
            FileWriter writer = new FileWriter(this.fileName);
            for (String key:this.words.keySet()) {
                writer.write(key + ":" + this.words.get(key) + "\n");
            }
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public String toString() {
        String output = "{";
        for (String key:this.words.keySet()) {
            output += key + ": " + this.words.get(key) + "\n";
        }
        
        return output + "}";
    }
}
