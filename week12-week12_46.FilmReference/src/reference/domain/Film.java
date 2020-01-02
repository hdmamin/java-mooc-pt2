/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 *
 * @author hmamin
 */
public class Film {
    private String name;
    
    public Film(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(Object object) {
        if (object.getClass() != getClass()) {
            return false;
        }
        
        Film film = (Film) object;
        return film.getName().equals(this.name);
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
}
