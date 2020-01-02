
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
    }

    private static void printWithSmileys(String word) {
        String smiley = ":)";
        int smileyLength = smiley.length();
        int length = word.length();
        int filledLength = length + 2 + 2*smileyLength;
        int numSmileysFull = (int)Math.ceil((double)filledLength / smileyLength);
        
        printAllSmileys(smiley, numSmileysFull);
        printMidRow(smiley, word);
        printAllSmileys(smiley, numSmileysFull);
      
    }
    
    public static void printAllSmileys(String smiley, int numSmileys) {
          for (int i=0; i<numSmileys; i++) {
            System.out.print(smiley);
        }
          System.out.println("");
    }
    
    public static void printMidRow(String smiley, String word) {
        System.out.print(smiley);
        System.out.print(" " + word + " ");
        if (word.length() % 2 == 1) {
            System.out.print(" ");
        }
        System.out.print(smiley);
        System.out.println("");
    }
}
