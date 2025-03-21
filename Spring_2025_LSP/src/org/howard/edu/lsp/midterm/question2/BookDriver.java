package org.howard.edu.lsp.midterm.question2;

/**
 * The BookDriver class is used to test the Book class.
 * It creates multiple Book objects and demonstrates the functionality
 * of the equals method and toString method.
 * 
 * @author Aaryan
 * @version 1.0
 */
public class BookDriver {

    /**
     * The main method serves as the entry point of the program.
     * It creates Book objects and compares them using the equals method,
     * then prints the results.
     * 
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Create Book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Compare books using equals method
        System.out.println(book1.equals(book2)); // true
        System.out.println(book1.equals(book3)); // false

        // Print book details using toString method
        System.out.println(book1);
    }
}
