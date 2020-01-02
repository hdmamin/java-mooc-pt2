/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

/**
 *
 * @author hmamin
 */
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class WordInspection {
    private File file;
    private ArrayList<String> lines;
   
    public WordInspection(File file) {
        this.file = file;
        this.lines = readLines();
    }
    
    public ArrayList<String> readLines() {
        Scanner reader = null;
        ArrayList<String> lines = new ArrayList<String>();
        
        try {
            reader = new Scanner(this.file, "UTF-8");
        } catch (Exception e) {
            System.out.println("Error reading file.");
            return lines;
        }
        
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        
        return lines;
    }
    
    public int wordCount() {
        // Really implements line count, per instructinos.
        return this.lines.size();
    }
    
    public List<String> wordsContainingZ() {
        ArrayList<String> words = new ArrayList<String>();
        
        for (String word:this.lines) {
            if (word.contains("z")) {
                words.add(word);
            }
        }
        
        return words;
    }
    
    public List<String> wordsEndingInL() {
        ArrayList<String> words = new ArrayList<String>();
        
        for (String word:this.lines) {
            if (word.endsWith("l")) {
                words.add(word);
            }
        }
        
        return words;
    }
    
    public List<String> palindromes() {
        ArrayList<String> words = new ArrayList<String>();
        
        for (String word:this.lines) {
            if (isPalindrome(word)) {
                words.add(word);
            }
        }
        
        return words;
    }
    
    public boolean isPalindrome(String word) {
        int length = word.length();
        for (int i=0; i<length; i++) {
            if (!(word.charAt(i) == word.charAt(length-1-i))) {
                return false;
            }
        }
        
        // False if word is only spaces.
        return !word.isEmpty();
    }

    public List<String> wordsWhichContainAllVowels() {
        String vowels = "aeiouyäö";
        ArrayList<String> words = new ArrayList<String>();
        
        for (String word:this.lines) {
            boolean flag = true;
            word = word.toLowerCase();
            for (int i=0; i<vowels.length(); i++) {
                if (!word.contains("" + vowels.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            
            // If all vowels present, flag will stay true;
            if (flag) {
                words.add(word);
            }
        }
        
        return words;
    }
}
