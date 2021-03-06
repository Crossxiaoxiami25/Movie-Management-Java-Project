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

import java.util.Comparator;

public class TitleComparator implements Comparator{
    /**
     * Title Comparator
     * @param left
     * left index of movie
     * @param right
     * right index of movie
     * @return
     * if left equal right return 0, if left great right Then return 1, otherwise return -1
     */
    @Override
    public int compare(Object left, Object right) {
        return ((Movie)left).getTitle().compareTo(((Movie)right).getTitle());
    }
    
}
