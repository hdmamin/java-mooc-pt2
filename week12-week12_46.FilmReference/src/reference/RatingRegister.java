/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;
/**
 *
 * @author hmamin
 */
public class RatingRegister {
    private Map<Film, List<Rating>> filmToRatings;
    private Map<Person, Map<Film, Rating>> personToRatings;
    
    public RatingRegister() {
        this.filmToRatings = new HashMap<Film, List<Rating>>();
        this.personToRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if (this.filmToRatings.containsKey(film)) {
            this.filmToRatings.get(film).add(rating);
        } else {
            List<Rating> newRating = new ArrayList<Rating>();
            newRating.add(rating);
            this.filmToRatings.put(film, newRating);
        }
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        // Update personToRatings dict.
        if (this.personToRatings.containsKey(person)) {
            this.personToRatings.get(person).put(film, rating);
        } else {
            Map<Film, Rating> filmToRating = new HashMap<Film, Rating>();
            filmToRating.put(film, rating);
            this.personToRatings.put(person, filmToRating);
        }
        
        // Update filmToRatings dict.
        if (this.filmToRatings.containsKey(film)) {
            this.filmToRatings.get(film).add(rating);
        } else {
            List<Rating> newRating = new ArrayList<Rating>();
            newRating.add(rating);
            this.filmToRatings.put(film, newRating);
        }
    }
    
    public List<Rating> getRatings(Film film) {
        return this.filmToRatings.get(film);
    }
    
    public Rating getRating(Person person, Film film) {
        Map<Film, Rating> ratings = this.personToRatings.get(person);
        Rating rating = Rating.NOT_WATCHED;

        if (ratings != null & ratings.containsKey(film)) {
            rating = ratings.get(film);
        }
        
        return rating;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        Map<Film, Rating> ratings = this.personToRatings.get(person);
        if (ratings == null) {
            ratings = new HashMap<Film, Rating>();
        }
        
        return ratings;
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return filmToRatings;
    }
    
    public List<Person> reviewers() {
        List<Person> output = new ArrayList<Person>();
        for (Person person:this.personToRatings.keySet()) {
            output.add(person);
        }
        
        return output;
    }
    
}
