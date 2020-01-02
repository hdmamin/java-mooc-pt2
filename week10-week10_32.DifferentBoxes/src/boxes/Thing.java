package boxes;

import java.lang.IllegalArgumentException;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException();
        }
        
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    public boolean equals(Object object) {
        if (object.getClass() != getClass()) {
            return false;
        }
        
        Thing thing = (Thing) object;
        return this.name.equals(thing.getName());
    }

}
