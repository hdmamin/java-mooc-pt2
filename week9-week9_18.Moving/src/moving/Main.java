package moving;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import moving.domain.Item;
import moving.domain.Thing;
import moving.domain.Box;
import moving.logic.Packer;

public class Main {

    public static void main(String[] args) {
        // test your program here
//        Item fork = new Item("fork", 4);
//        Item knife = new Item("knife", 2);
//        Item plate = new Item("plate", 13);
//        System.out.println(fork);
//        
//        List<Thing> things = new ArrayList<Thing>();
//        things.add(fork);
//        things.add(knife);
//        things.add(plate);
//        
////        Collections.sort(things);
//        System.out.println(things);
//        
//        Packer packer = new Packer(14);
//        List<Box> boxes = packer.packThings(things);
//        System.out.println(boxes);
        
        List<Thing> things = new ArrayList<Thing>();
        things.add( new Item("Stone", 9) );
        things.add( new Item("Stone", 6) );
        things.add( new Item("Stone", 1) );
        things.add( new Item("Stone", 5) );
        things.add( new Item("Stone", 3) );
        Packer packer = new Packer(20);
        List<Box> boxes = packer.packThings(things);
        System.out.println(boxes);
    }
}
