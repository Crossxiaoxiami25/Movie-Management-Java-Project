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

public class CountComparator implements Comparator{
    /**
     * Count Comparator
     * @param left
     * left index of Actor
     * @param right
     * right index of Actor
     * @return
     * if left equal right return 0, if left great right Then return 1, otherwise return -1
     */
    @Override
    public int compare(Object left, Object right) {
        return Integer.compare(((Actor)left).getCount(),((Actor)right).getCount());
    }
    
}
