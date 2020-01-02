/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hmamin
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> words;
    private int duplicates;
    
    public PersonalDuplicateRemover() {
        this.words = new HashSet<String>();
        this.duplicates = 0;
    }

    public void add(String word) {
        if (!this.words.contains(word)) {
            this.words.add(word);
        } else {
            this.duplicates++;
        }
    }

    public int getNumberOfDetectedDuplicates() {
        return this.duplicates;
    }

    public Set<String> getUniqueCharacterStrings() {
        return this.words;
    }

    public void empty() {
        this.words.clear();
        this.duplicates = 0;
    }
    
}
