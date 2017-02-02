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

public class Actor {

    private String name;
    private int count = 0;
    /**
     * Constructor with name to set
     * @param name 
     * the name to be set
     */
    public Actor(String name) {
        this.name = name;
        count = 1;
    }
    /**
     * Get name of current object
     * @return 
     * the name of current object
     */
    public String getName() {
        return name;
    }
    /**
     * Get movie Count of current object
     * @return 
     * the movie count of current object
     */
    public int getCount() {
        return count;
    }
    /**
     * Set the movie count
     * @param val 
     * the movie count to be set
     */
    public void setCount(int val) {
        count += val;
    }
    /**
     * The String of current object information
     * @return 
     * the string of information
     */
    public String toString() {
        return String.format("%-40s%-2d", name, count);
    }
}
