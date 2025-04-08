package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.howard.edu.lsp.assignment6.IntegerSetException;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;




public class IntegerSetTest {
	
	
	
		private IntegerSet set1;
		private IntegerSet set2;
		
		
		
		@BeforeEach
		public void setUp() {
			set1 = new IntegerSet();
			set2 = new IntegerSet();
			
		}
		
		
		@Test
	    @DisplayName("Test for add()")
	    public void testAdd() {
	        set1.add(5);
	        set1.add(10);
	        set1.add(5);  // duplicate
	        assertEquals(2, set1.length());
	        assertTrue(set1.contains(10));
	    }
		
		
		
		@Test
	    @DisplayName("Test for clear()")
	    public void testClear() {
	        set1.add(1);
	        set1.add(2);
	        assertFalse(set1.isEmpty());
	        set1.clear();
	        assertTrue(set1.isEmpty());
	    }

		
		
		
		@Test
	    @DisplayName("Test for length()")
	    public void testLength() {
	        assertEquals(0, set1.length());
	        set1.add(1);
	        set1.add(2);
	        assertEquals(2, set1.length());
	        
	        
	        
	    }
		
		
		@Test
		@DisplayName("Test for largest() with exception")
		public void testLargest() throws IntegerSetException {
		    // Ensure exception is thrown when set is empty
		    set1.clear();  // Important to clear before testing empty case
		    Exception exception = assertThrows(IntegerSetException.class, () -> {
		        set1.largest();
		    });
		    assertEquals("Set is empty", exception.getMessage());

		    // Test for correct largest value
		    set1.add(1);
		    set1.add(5);
		    set1.add(3);
		    assertEquals(5, set1.largest());
		}

		
		

		@Test
		@DisplayName("Test for smallest() with exception")
		public void testSmallest() throws IntegerSetException {
		    // Ensure exception is thrown when set is empty
		    set1.clear();  // Important to clear before testing empty case
		    Exception exception = assertThrows(IntegerSetException.class, () -> {
		        set1.smallest();
		    });
		    assertEquals("Set is empty", exception.getMessage());

		    // Test for correct smallest value
		    set1.add(4);
		    set1.add(-1);
		    set1.add(7);
		    assertEquals(-1, set1.smallest());
		}


	    @Test
	    @DisplayName("Test for contains()")
	    public void testContains() {
	        set1.add(3);
	        assertTrue(set1.contains(3));
	        assertFalse(set1.contains(99));
	    }

	    @Test
	    @DisplayName("Test for remove()")
	    public void testRemove() {
	        set1.add(1);
	        set1.add(2);
	        set1.remove(1);
	        assertFalse(set1.contains(1));
	        set1.remove(100); // removing non-existent element
	        assertEquals(1, set1.length());
	    }

	    @Test
	    @DisplayName("Test for equals()")
	    public void testEquals() {
	        set1.add(3);
	        set2.add(1);
	        set1.add(1);
	        set2.add(3);
	        set1.add(2);
	        set2.add(2);
	        assertTrue(set1.equals(set2));
	        set2.add(4);
	        assertFalse(set1.equals(set2));
	    }

	    @Test
	    @DisplayName("Test for isEmpty()")
	    public void testIsEmpty() {
	        assertTrue(set1.isEmpty());
	        set1.add(1);
	        assertFalse(set1.isEmpty());
	    }

	    @Test
	    @DisplayName("Test for toString()")
	    public void testToString() {
	        set1.add(1);
	        set1.add(2);
	        assertEquals(set1.toString(), "[1, 2]");
	    }

	    @Test
	    @DisplayName("Test for union()")
	    public void testUnion() {
	        set1.add(1);
	        set1.add(2);
	        set2.add(2);
	        set2.add(3);
	        set1.union(set2);
	        assertEquals(set1.toString(), "[1, 2, 3]");
	    }

	    @Test
	    @DisplayName("Test for intersect()")
	    public void testIntersect() {
	        set1.add(1);
	        set1.add(2);
	        set1.add(3);
	        set2.add(2);
	        set2.add(3);
	        set2.add(4);
	        set1.intersect(set2);
	        assertEquals(set1.toString(), "[2, 3]");
	    }

	    @Test
	    @DisplayName("Test for diff()")
	    public void testDiff() {
	        set1.add(1);
	        set1.add(2);
	        set1.add(3);
	        set2.add(3);
	        set2.add(4);
	        set1.diff(set2);
	        assertEquals(set1.toString(), "[1, 2]");
	    }

	    @Test
	    @DisplayName("Test for complement()")
	    public void testComplement() {
	        set1.add(1);
	        set1.add(2);
	        set2.add(2);
	        set2.add(3);
	        set2.add(4);
	        set1.complement(set2);  // set1 becomes elements in set2 not in set1
	        assertEquals(set1.toString(), "[3, 4]");
	    }


	}