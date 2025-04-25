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

//extra credit //Remove existing item



package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShoppingCart Unit Tests")
class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test adding a valid item to cart")
    void testAddValidItem() {
        cart.addItem("Notebook", 15.0);
        assertEquals(15.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test adding item with negative price throws exception")
    void testAddItemWithNegativePriceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("InvalidItem", -10.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }
    
    
    @Test
    @DisplayName("Test adding item with zero price throws exception")
    void testAddItemWithZeroPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("InvalidItem", 0.0);
        });
        assertEquals("Price cannot be zero.", exception.getMessage());
    }

    @Test
    @DisplayName("Test applying SAVE10 discount code")
    void testApplySAVE10Discount() {
        cart.addItem("Item", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.001);
        assertEquals(90.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test applying SAVE20 discount code")
    void testApplySAVE20Discount() {
        cart.addItem("Item", 200.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.001);
        assertEquals(160.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test applying invalid discount code throws exception")
    void testApplyInvalidDiscountCodeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test total cost calculation without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Shirt", 25.0);
        cart.addItem("Tie", 10.0);
        assertEquals(35.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test removing existing item returns true")
    public void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 15.0);
        assertTrue(cart.removeItem("Book"));
    }

    @Test
    @DisplayName("Test removing non-existent item returns false")
    public void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 1.5);
        assertFalse(cart.removeItem("Notebook"));
    }

    @Test
    @DisplayName("Test total cost calculation with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Shoes", 100.0);
        cart.addItem("Socks", 20.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(108.0, cart.getTotalCost()); 
    }

    @Test
    @DisplayName("Test total cost with empty cart returns zero")
    void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost());
    }
}
