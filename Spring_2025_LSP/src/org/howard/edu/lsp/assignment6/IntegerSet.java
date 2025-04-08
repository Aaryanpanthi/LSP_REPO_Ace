package org.howard.edu.lsp.assignment6;
import java.util.*;

/**
 * A class representing a set of integers with various operations.
 * The set is implemented using an ArrayList to store elements.
 */ 
public class IntegerSet  {
	// Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	//
	
	 /**
     * Default constructor that creates an empty IntegerSet.
     */
	public IntegerSet() {
		
	}

	 /**
     * Constructor that creates an IntegerSet from an existing ArrayList.
     * @param set The ArrayList containing initial set elements
     */
	
	// Constructor if you want to pass in already initialized
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}
	
	
	/**
	 * Removes all element from the set
	 */

    public void clear() {
    	set.clear();
    }
    
    /**
     * Returns the number of elements in the set.
     * @return The size of the set
     */
    
    // Returns the length of the set. 5 pts.
    public int length() {
        return set.size();
    }

    /*
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
     * This overrides the equals method from the Object class. 10 pts.
     */
    
    
    
    /**
     * Compares this set with another object for equality.
     * Two sets are equal if they contain all of the same values in any order.
     * @param o The object to compare with
     * @return true if the sets are equal, false otherwise
     */
    
    
    
    @Override
    public boolean equals(Object o) {
        // 1. Check if references are the same
        if (this == o) {
            return true;
        }
     

      
        IntegerSet otherSet = (IntegerSet) o;

     
        if (this.set.size() != otherSet.set.size()) {
            return false;
        }

   
        List<Integer> thisCopy = new ArrayList<>(this.set);
        List<Integer> otherCopy = new ArrayList<>(otherSet.set);
        Collections.sort(thisCopy);
        Collections.sort(otherCopy);

        // 6. Compare sorted copies
        return thisCopy.equals(otherCopy);
    }

    
    
    /**
     * Checks if the set contains a specific value.
     * @param value The integer value to check for
     * @return true if the value is in the set, false otherwise
 
     */
    
    
    // Returns true if the set contains the value, otherwise false. 5 pts.
    public boolean contains(int value) {
        // Simpler approach: use built-in contains
        // return this.set.contains(value);

        // Or do the manual loop:
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) == value) {
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * FINDS THE LARGEST ELEMENT IN THE SET
     * @return The largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    // Returns the largest item in the set. 5 pts.
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int maximum = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }
    
    
    
    /**
     * FINDS THE Smallest ELEMENT IN THE SET
     * @return The Smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    
    // Returns the smallest item in the set. 5 pts.
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int minimum = Integer.MAX_VALUE;
        for (int num : set) {
            if (num < minimum) {
                minimum = num;
            }
        }
        return minimum;
    }
    
    /**
     * Checks if the set already contains the given item or not. If it doesn't contain , it adds to the set. 
     * @param item The Integer to add to the set
     */
    
    
    // Adds an item to the set or does nothing if it is already there. 5 pts.
    public void add(int item) {
        // Check if the item is already present
        if (!set.contains(item)) {
        	 set.add(item);
        }
    }
    
    /**
     * Removes an element from the set if it exists
     * @param item The integer to remove from the set
     */ 

    // Removes an item from the set or does nothing if not there. 5 pts.
    public void remove(int item) {
        // If the item is found, remove it & break out
        for (int i = 0; i < this.set.size(); i++) {
            if (this.set.get(i) == item) {
                this.set.remove(i);
                return;  // done removing
            }
        }
    }
	    
    
  /**
   * Does the union operation with another IntegerSet.
   * Adds all the elements from another IntegerSet to this set if it doesn't exist in this set. 
   * @param intSetb The other integer set to union with. 
   */
public void union(IntegerSet intSetb) {
	for (int element : intSetb.set) {
        if (!set.contains(element)) {
            set.add(element);
        }
    }
}



/**
 * Performs set intersections with another IntegerSet
 * Modifies this set to contain only elements that are present in both Sets. 
 * @param intSetb the other IntegerSet to intersect with
 */

// Set intersection, all elements in s1 and s2. 12 pts.
public void intersect(IntegerSet intSetb) {
	set.retainAll(intSetb.set);
}

/**
 * Performs set differences operations( this set minus the other set).
 * Removes all the elements from this set that are present in another set 
 * @param intSetb the other IntegerSet to compare with
 */

// Set difference, i.e., s1 –s2. 12 pts.
public void diff(IntegerSet intSetb) {
	set.removeAll(intSetb.set);	
} // set difference, i.e. s1 - s2



/**
 * Performs complement operations
 * Uses an dummy array list to add the values  of this set that are not present in another set
 * @param intSetb The IntegetSet to use for complement operation. 
 */
// Set complement, all elements not in s1. 11 pts.
public void complement(IntegerSet intSetb) {
	
	List<Integer> dummySet = new ArrayList<>();
	
	for(int i=0; i < intSetb.length(); i++) {
		if(!this.set.contains(intSetb.set.get(i))){ 
			dummySet.add(intSetb.set.get(i));
		}
	}
	this.set.clear();
	this.set.addAll(dummySet);
}


/**
 * checks if the set is empty
 * @return true if the set contains no elements, false otherwise. 
 */
// Returns true if the set is empty, false otherwise. 5 pts.
public boolean isEmpty() {
	return this.length() == 0;
}

// Return String representation of your set.  This overrides the equal method from 
// the Object class. 5 pts.

/**
 * Returns a string representation  of set enclosed in square brackets. 
 * @return A strinf representation of set 
 */

@Override
public String toString() {
	return set.toString();

};	// return String representation of your set
}
