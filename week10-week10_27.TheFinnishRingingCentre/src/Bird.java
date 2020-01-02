
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    public String getName() {
        return this.name;
    }
    
    public String getLatinName() {
        return this.latinName;
    }
    
    public int getRingingYear() {
        return this.ringingYear;
    }
    
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        
        Bird bird = (Bird) obj;
        return this.ringingYear == bird.getRingingYear() & this.latinName.equals(bird.getLatinName());
    }
    
    public int hashCode() {
        return this.latinName.hashCode() + this.ringingYear;
    }
    
    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


