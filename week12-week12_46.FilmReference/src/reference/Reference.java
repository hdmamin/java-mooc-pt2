/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;
/**
 *
 * @author hmamin
 */
public class Reference {
    private RatingRegister register;
    
    public Reference(RatingRegister register) {
        this.register = register;
    }
    
    public Film recommendFilm(Person person) {
        FilmComparator comparator = new FilmComparator(register.filmRatings());
        List<Film> films = new ArrayList<Film>();
        Map<Film, Rating> personalRatings = register.getPersonalRatings(person);
        
        // Case where user hasn't rated any movies yet.
        if (personalRatings.isEmpty()) {
            for (Film film:register.filmRatings().keySet()) {
                films.add(film);
            }
            Collections.sort(films, comparator);
            return films.get(0);
        }
        
        // Case where user has rated at least 1 movie.
        Person nearestPerson = closestNeighbor(person);
        Map<Film, Rating> neighborRatings = this.register.getPersonalRatings(nearestPerson);
        Film recFilm = null;
        int recScore = 0;
        
        for (Film film:neighborRatings.keySet()) {
            int currScore = neighborRatings.get(film).getValue();
            if (!personalRatings.containsKey(film) & currScore > recScore) {
                recFilm = film;
                recScore = currScore;
            }
        }
        
        // TEMP - eventually need to return Film;
        return recFilm;
    }
    
    public Person closestNeighbor(Person person) {
        // Find most similar user.
        int maxSim = Integer.MIN_VALUE;
        Person nearestPerson = null;
        for (Person reviewer:this.register.reviewers()) {
            if (person != reviewer) {
                int sim = similarity(person, reviewer);
                if (sim > maxSim) {
                    maxSim = sim;
                    nearestPerson = reviewer;
                }
            }
        }
        
        return nearestPerson;
    }
    
    public int similarity(Person person1, Person person2) {
        // Compute similarity score between two reviewers (high positive value 
        // means very similar, high negative means very dissimilar.
        Map<Film, Rating> reviews1 = this.register.getPersonalRatings(person1);
        Map<Film, Rating> reviews2 = this.register.getPersonalRatings(person2);
        
        int sim = 0;
        for (Film film:this.register.filmRatings().keySet()) {
            if (reviews1.containsKey(film) & reviews2.containsKey(film)) {
                sim += reviews1.get(film).getValue() * reviews2.get(film).getValue();
            }
        }
        
        return sim;
    }
    
}
