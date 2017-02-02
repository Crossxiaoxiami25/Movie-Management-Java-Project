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
import big.data.DataSource;
import java.util.List;

public class Movie {

    private String title;
    private int year;
    private List<Actor> actorList;
    private String[] actorSA;

    /**
     * Constructor with set title and movie year
     *
     * @param title the title to be set
     * @param year the year to be set
     */
    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
        actorList = new ArrayList<Actor>();
    }

    /**
     * Constructor with URL to find the movie information in big data library
     *
     * @param url the URL
     */
    public Movie(String url) {
        DataSource ds = DataSource.connectXML(url);
        ds.load();
        title = ds.fetchString("movie/title");
        year = ds.fetchInt("movie/year");
        String actorLS = ds.fetchString("movie/actors");
        actorSA = actorLS.split(",");
        actorSA[0] = " " + actorSA[0];
    }

    /**
     * Get the current movie Title
     *
     * @return the movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the current movie year
     *
     * @return the year of movie
     */
    public int getYear() {
        return year;
    }

    /**
     * Get the current movie actors
     *
     * @return the list of actors
     */
    public List<Actor> getActors() {
        return actorList;
    }

    /**
     * Set the current movie actors
     *
     * @param al the list of actors to be set
     */
    public void setActors(List<Actor> al) {
        actorList = al;
    }
    /**
     * Get Actor String Array
     * @return 
     * string array of Actor
     */
    public String[] getActorSA(){
        return actorSA;
    }

    /**
     * String of current movie information
     *
     * @return the string of current movie information
     */
    public String toString() {
        String al = "";
        for (int i = 0; i < actorList.size(); i++) {
            if (i == actorList.size() - 1) {
                al += actorList.get(i).getName();
            } else {
                al += actorList.get(i).getName() + ",";
            }
        }
        return String.format("%-50s%-2d%-10s", title, year, al);
    }
}
