
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Scanner reader = new Scanner(System.in);
        dict.add("apina", "monkey");
        dict.add("banaani", "banana");
        dict.add("cembalo", "harpsichord");
        
        System.out.println(dict.amountOfWords());
        System.out.println(dict.translate("banaani"));
        ArrayList<String> translations = dict.translationList();
        for (String trans:translations) {
            System.out.println(trans);
        }
        
        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
    }
}
