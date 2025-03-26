package org.howard.edu.lsp.assignment5;
import java.util.*;


public class IntegerSet  {
	// Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	public IntegerSet() {
		
	}

	// Constructor if you want to pass in already initialized
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}


    public void clear() {
    	set.clear();
    }

    // Returns the length of the set. 5 pts.
    public int length() {
        return set.size();
    }

    /*
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
     * This overrides the equals method from the Object class. 10 pts.
     */
    @Override
    public boolean equals(Object o) {
        // 1. Check if references are the same
        if (this == o) {
            return true;
        }
     

        // 3. Cast to IntegerSet
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

    // Returns the largest item in the set. 5 pts.
    public int largest() {
    	
    	
        // If the set can be empty, consider throwing an exception or handling that case.
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) > maximum) {
                maximum = set.get(i);
            }
        }
        return maximum;
    }

    // Returns the smallest item in the set. 5 pts.
    public int smallest() {
    	
        // If the set can be empty, consider throwing an exception or handling that case.
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) < minimum) {
                minimum = set.get(i);
            }
        }
        return minimum;
    }

    // Adds an item to the set or does nothing if it is already there. 5 pts.
    public void add(int item) {
        // Check if the item is already present
        if (!set.contains(item)) {
        	 set.add(item);
        }
    }

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
	    
public void union(IntegerSet intSetb) {
	for (int element : intSetb.set) {
        if (!set.contains(element)) {
            set.add(element);
        }
    }
}




// Set intersection, all elements in s1 and s2. 12 pts.
public void intersect(IntegerSet intSetb) {
	set.retainAll(intSetb.set);
}

// Set difference, i.e., s1 –s2. 12 pts.
public void diff(IntegerSet intSetb) {
	set.removeAll(intSetb.set);	
} // set difference, i.e. s1 - s2

// Set complement, all elements not in s1. 11 pts.
public void complement(IntegerSet intSetb) {
	set.removeIf(item -> intSetb.contains(item));
}

// Returns true if the set is empty, false otherwise. 5 pts.
public boolean isEmpty() {
	 return set.isEmpty();
}

// Return String representation of your set.  This overrides the equal method from 
// the Object class. 5 pts.
public String toString() {
	return set.toString();

};	// return String representation of your set
}
