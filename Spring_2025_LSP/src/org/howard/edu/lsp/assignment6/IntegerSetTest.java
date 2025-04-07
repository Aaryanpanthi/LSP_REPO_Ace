package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    void testAddAndContains() {
        set1.add(5);
        set1.add(10);
        assertTrue(set1.contains(5));
        assertFalse(set1.contains(3));
    }

    @Test
    void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    void testLargest() {
        set1.add(3);
        set1.add(10);
        set1.add(7);
        assertEquals(10, set1.largest());
    }

    @Test
    void testSmallest() {
        set1.add(3);
        set1.add(10);
        set1.add(2);
        assertEquals(2, set1.smallest());
    }

    @Test
    void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(3, set1.length());
    }

    @Test
    void testClearAndIsEmpty() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    void testToString() {
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString());
    }
}
