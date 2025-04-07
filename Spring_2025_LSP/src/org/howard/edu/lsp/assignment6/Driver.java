package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        System.out.println("========= TESTING IntegerSet =========");

        // Test 1: Add & toString
        IntegerSet set1 = new IntegerSet();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(10);  // duplicate
        System.out.println("Set1 after adding 10, 20, 30, 10: " + set1);

        // Test 2: Remove
        set1.remove(20);
        System.out.println("Set1 after removing 20: " + set1);
        set1.remove(100);  // non-existent
        System.out.println("Set1 after trying to remove 100: " + set1);

        // Test 3: Length
        System.out.println("Length of Set1: " + set1.length());

        // Test 4: Contains
        System.out.println("Set1 contains 10? " + set1.contains(10));
        System.out.println("Set1 contains 50? " + set1.contains(50));

        // Test 5: isEmpty
        System.out.println("Set1 is empty? " + set1.isEmpty());

        // Test 6: Clear
        set1.clear();
        System.out.println("Set1 after clear: " + set1);
        System.out.println("Set1 is empty after clear? " + set1.isEmpty());

        // Test 7: Smallest and Largest with values
        set1.add(5);
        set1.add(15);
        set1.add(25);
        System.out.println("Set1: " + set1);
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set1: " + set1.largest());

        // Test 8: Exception handling for smallest/largest
        set1.clear();
        try {
            set1.smallest();
        } catch (RuntimeException e) {
            System.out.println("Caught exception for smallest on empty set: " + e.getMessage());
        }

        try {
            set1.largest();
        } catch (RuntimeException e) {
            System.out.println("Caught exception for largest on empty set: " + e.getMessage());
        }

        // Test 9: equals
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(1);
        System.out.println("SetA: " + setA);
        System.out.println("SetB: " + setB);
        System.out.println("SetA equals SetB? " + setA.equals(setB));

        // Test 10: Union
        setA.add(3);
        setB.add(4);
        System.out.println("Before Union - SetA: " + setA + ", SetB: " + setB);
        setA.union(setB);
        System.out.println("After Union - SetA: " + setA);

        // Test 11: Intersection
        IntegerSet setC = new IntegerSet();
        setC.add(2);
        setC.add(3);
        setC.add(5);
        System.out.println("Before Intersection - SetA: " + setA + ", SetC: " + setC);
        setA.intersect(setC);
        System.out.println("After Intersection - SetA: " + setA);

        // Test 12: Difference
        IntegerSet setD = new IntegerSet();
        setD.add(3);
        System.out.println("Before Difference - SetA: " + setA + ", SetD: " + setD);
        setA.diff(setD);
        System.out.println("After Difference - SetA: " + setA);

        // Test 13: Complement
        IntegerSet setE = new IntegerSet();
        setE.add(10);
        setE.add(20);
        setE.add(3);  // common with A
        System.out.println("Before Complement - SetA: " + setA + ", SetE: " + setE);
        setA.complement(setE);
        System.out.println("After Complement (SetA = SetE - SetA): " + setA);

        // Test 14: Constructor with ArrayList
        ArrayList<Integer> initialList = new ArrayList<>();
        initialList.add(7);
        initialList.add(8);
        IntegerSet setF = new IntegerSet(initialList);
        System.out.println("SetF initialized with ArrayList: " + setF);

        System.out.println("========= END OF TESTS =========");
    }
}
