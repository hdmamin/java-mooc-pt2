package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection inspection = new WordInspection(file);
        System.out.println(inspection.wordsContainingZ());
        System.out.println(inspection.wordsEndingInL());
        System.out.println(inspection.wordsWhichContainAllVowels());
    }
}
