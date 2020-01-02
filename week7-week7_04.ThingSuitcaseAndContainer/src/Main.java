
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Thing wagon = new Thing("wagon", 16);
        Thing book = new Thing("book", 1);
        Thing dino = new Thing("dinosaur", 5);
        
        Suitcase suitcase = new Suitcase(20);
        suitcase.addThing(wagon);
        System.out.println(suitcase);
        suitcase.addThing(book);
        System.out.println(suitcase);
        suitcase.addThing(dino);
        System.out.println(suitcase);
        
        suitcase.printThings();
        
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i=1; i<=100; i++) {
            Suitcase sc = new Suitcase(100);
            sc.addThing(new Thing("brick", i));
            container.addSuitcase(sc);
        }
        
        System.out.println(container);
    }

}
