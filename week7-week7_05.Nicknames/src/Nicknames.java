
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String, String> name2Nick = new HashMap<String, String>();
        name2Nick.put("matti", "mage");
        name2Nick.put("mikael", "mixu");
        name2Nick.put("arto", "arppa");
        
        System.out.println(name2Nick.get("mikael"));
    }

}
