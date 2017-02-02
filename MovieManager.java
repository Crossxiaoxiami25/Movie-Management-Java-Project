/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 7
 * CSE214-01
 * Charles Chen
 * Shilpi Bhattacharyya
 */
package homwork7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieManager {

    private List<Movie> movies;
    private List<Actor> actors;

    /**
     * Default constructor set movies list and actors list to empty
     */
    public MovieManager() {
        movies = new ArrayList<Movie>();
        actors = new ArrayList<Actor>();
    }

    /**
     * Set And Return current Movies
     *
     * @param nm the movie to be add
     * @return the added movie
     */
    public Movie setAndReturnMovies(Movie nm) {
        boolean isExist = false;
        movies.add(nm);
        List<Actor> tempActorList = new ArrayList<Actor>();
        for (int j = 0; j < nm.getActorSA().length; j++) {
            for (int i = 0; i < actors.size(); i++) {
                if (nm.getActorSA()[j].equalsIgnoreCase(actors.get(i).getName())) {
                    actors.get(i).setCount(1);
                    tempActorList.add(actors.get(i));
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                Actor temp = new Actor(nm.getActorSA()[j]);
                actors.add(temp);
                tempActorList.add(temp);
            }
            isExist = false;
        }
        nm.setActors(tempActorList);
        return nm;
    }

    /**
     * Get movies list
     *
     * @return the list of movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Get all actors list
     *
     * @return the list of all actors
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Get Sorted Movies list
     *
     * @param comp Sorted by a Comparator
     * @return the Sorted Movies list
     */
    public List<Movie> getSortedMovies(Comparator comp) {
        Collections.sort(movies, comp);
        return movies;
    }

    /**
     * Get Sorted Actors list
     *
     * @param comp Sorted by a Comparator
     * @return the Sorted Actors list
     */
    public List<Actor> getSortedActors(Comparator comp) {
        Collections.sort(actors, comp);
        return actors;
    }
}
