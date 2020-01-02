package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        PersonalMultipleEntryDictionary dict = new PersonalMultipleEntryDictionary();
        dict.add("kuusi", "six");
        dict.add("kuusi", "spruce");
        dict.add("pii", "silicon");
        dict.add("pii", "silicon");
        
        System.out.println(dict.translate("kuusi"));
        System.out.println(dict.translate("pii"));
    }
}
