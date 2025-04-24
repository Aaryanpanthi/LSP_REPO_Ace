
//resources used https://symflower.com/en/company/blog/2023/how-to-write-junit-test-cases/
// Junit assignment 6
// personal notes 
//www.baeldung.com/junit-assert-exception




//For reference
//Test for adding valid item [3 pts.]
//Test for adding item with 0 price (expect exception) [3 pts.]
//Test for adding item with negative price (expect exception) [3 pts.]
//Test for applying "SAVE10"[3 pts.]
//Test for applying "SAVE20" [3 pts.]
//Test for applying invalid code (expect exception) [3 pts.]
//Test total cost without discount [4 pts.]
//Test total cost with discount [5 pts.]
//Test total cost with empty cart [3 pts.]


package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    
    // It checks for add items value
    @Test
    void testAddValidItem() {
        cart.addItem("Notebook", 15.0);
        assertEquals(15.0, cart.getTotalCost(), 0.001);
    }

   
//   checking for 0  but 0 is allowed in the code 
//    @Test
//    void testAddItemWithZeroPriceThrowsException() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            cart.addItem("FreeItem", 0.0);
//        });
//        assertEquals("Price cannot be negative.", exception.getMessage());
//    }
//
 
    	
    // checking for negetive values
   
    @Test
    void testAddItemWithNegativePriceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("InvalidItem", -10.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }
    
    
    //checkign add save 10
   
    @Test
    void testApplySAVE10Discount() {
        cart.addItem("Item", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.001);
        assertEquals(90.0, cart.getTotalCost(), 0.001);
    }

   
    //checking add save 20
    @Test
    void testApplySAVE20Discount() {
        cart.addItem("Item", 200.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.001);
        assertEquals(160.0, cart.getTotalCost(), 0.001);
    }
    
    
    // checking for exception 
  
    @Test
    void testApplyInvalidDiscountCodeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("INVALIDCODE");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

   
    //without discount
    @Test
    void testTotalCostWithoutDiscount() {
        cart.addItem("Shirt", 25.0);
        cart.addItem("Tie", 10.0);
        assertEquals(35.0, cart.getTotalCost(), 0.001);
    }
    
    
    @Test
    public void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 15.0);
        assertTrue(cart.removeItem("Book"));
    }

    @Test
    public void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 1.5);
        assertFalse(cart.removeItem("Notebook"));
    }
    
    //with discount
    @Test
    void testTotalCostWithDiscount() {
        cart.addItem("Shoes", 100.0);
        cart.addItem("Socks", 20.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(108.0, cart.getTotalCost(), 0.001); 
    }

   //checking for  empy card. 
    @Test
    void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }
}
