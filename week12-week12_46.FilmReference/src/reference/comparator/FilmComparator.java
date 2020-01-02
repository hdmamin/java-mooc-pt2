/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;
/**
 *
 * @author hmamin
 */
public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    public int compare(Film film1, Film film2) {
        // Sort by average rating, descending.
        List<Rating> ratings1 = this.ratings.get(film1);
        List<Rating> ratings2 = this.ratings.get(film2);
        
        int total1 = 0;
        double avg1 = 0.0;
        int total2 = 0;
        double avg2 = 0.0;
        
        if (ratings1 != null) {
            for (Rating rating:ratings1) {
                total1 += rating.getValue();
            }
            avg1 = (double) total1 / ratings1.size();
        }
        
        if (ratings2 != null) {
            for (Rating rating:ratings2) {
                total2 += rating.getValue();
            }
            avg2 = (double) total2 / ratings2.size();
        }
        
        return (int) Math.ceil(avg2 - avg1);
    }
}
