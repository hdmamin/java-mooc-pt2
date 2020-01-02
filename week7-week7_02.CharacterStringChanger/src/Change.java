/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
public class Change {
    private char fromChar;
    private char toChar;
    
    public Change(char fromChar, char toChar) {
        this.fromChar = fromChar;
        this.toChar = toChar;
    }
    
    public String change(String word) {
        String output = "";
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == this.fromChar) {
                output += this.toChar;
            } else {
                output += word.charAt(i);
            }
        }
        
        return output;
        
        // Built-in method.
//        return word.replace(this.fromChar, this.toChar);
    }
}
