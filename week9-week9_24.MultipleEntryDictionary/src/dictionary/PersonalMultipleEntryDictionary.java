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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> wordMap;
    
    public PersonalMultipleEntryDictionary() {
        this.wordMap = new HashMap<String, Set<String>>();
    }
    
    public void add(String word, String trans) {
        if (!this.wordMap.containsKey(word)) {
            this.wordMap.put(word, new HashSet<String>());
        }
        Set<String> translations = this.wordMap.get(word);
        translations.add(trans);
    }
    
    public void remove(String word) {
        this.wordMap.remove(word);
    }

    public Set<String> translate(String word){
        return this.wordMap.get(word);
    }
}
