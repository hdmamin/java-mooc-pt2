public class Main {
    public static void main(String[] args) {
        // Test your program here
        PromissoryNote note = new PromissoryNote();
        note.setLoan("Arto", 51.5);
        note.setLoan("Mikael", 30);
        
        System.out.println(note.howMuchIsTheDebt("Mikael"));
    }
}
