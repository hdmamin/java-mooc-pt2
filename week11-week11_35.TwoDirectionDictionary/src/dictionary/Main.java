package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        MindfulDictionary dict = new MindfulDictionary();
        dict.add("monkey", "apina");
        dict.add("banana", "banaani");
        dict.add("banana", "bobble");
        dict.add("dog", "dog_translation");
        
        System.out.println(dict.translate("banana"));
        System.out.println(dict.translate("apple"));
        
        dict.remove("banana");
        dict.remove("dog_translation");
        System.out.println(dict);
        
        // Load from file.
        MindfulDictionary dict2 = new MindfulDictionary("test/words.txt");
        dict2.load();
        System.out.println(dict2);
        dict2.remove("below");
        System.out.println(dict2);
    }
}
