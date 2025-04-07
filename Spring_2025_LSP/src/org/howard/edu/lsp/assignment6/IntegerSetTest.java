package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

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
		@DisplayName("Test for checking Clear")
		public void testClear() {
			
			set1.add(2);
			set1.add(1);
			
			assertNotEquals(0,set1.length()); 
			
			set1.clear();
			
			
			assertEquals(0,set1.length());
			
		}
		
		
		
		@Test
		@DisplayName("Test for checking Length")
		public void testLength() {
			
			assertEquals(0,set1.length());
			set1.add(2);
			set1.add(1);
			
			
			assertEquals(2,set1.length());
			
			set1.add(3);
			
			assertNotEquals(2,set1.length());
			
		}
		
		
		
		@Test 
		@DisplayName("Test for checking Largest")
		public void testLargest() {
			
			Exception exception = assertThrows(RuntimeException.class, () -> set1.largest());
			assertEquals("Set is empty", exception.getMessage());

			

			
			set1.add(2);
			set1.add(-2);
			set1.add(1);
			set1.add(3);
			set1.add(0);
			
			
			assertEquals(3,set1.largest());
			assertNotEquals(2,set1.largest());
			
			
		}
		
		

	    @Test
	    @DisplayName("Test case for equals")
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

	}

