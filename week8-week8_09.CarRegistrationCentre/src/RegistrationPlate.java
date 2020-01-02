
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    public String getRegCode() {
        return this.regCode;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    @Override
    public String toString() {
        return country + " " + regCode;
    }
    
    @Override
    public int hashCode() {
        return this.regCode.hashCode() + this.country.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        
        RegistrationPlate plate = (RegistrationPlate) obj;
        return this.regCode.equals(plate.getRegCode()) && this.country.equals(plate.getCountry());
    }

}
