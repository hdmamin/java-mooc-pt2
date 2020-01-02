public class Main {
    public static void main(String[] args) {
        // Test your program here
        String word = "alphabet";
        Change change = new Change('a', 'x');
        Change change2 = new Change('b', 'y');
        Changer changer = new Changer();
        changer.addChange(change);
        changer.addChange(change2);
        
        System.out.println(changer.change(word));
    }
}
