package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a Book with a title, author, ISBN, and publication year.
 * Provides methods for retrieving and updating these details, as well as 
 * overriding the equals and toString methods.
 * 
 * @author Aaryan
 * @version 1.0
 */
public class Book {

    /** The title of the book */
    private String title;

    /** The author of the book */
    private String author;

    /** The ISBN of the book */
    private String ISBN;

    /** The year the book was published */
    private int yearPublished;

    /**
     * Constructs a Book object with the specified title, author, ISBN, and year published.
     * 
     * @param title the title of the book
     * @param author the author of the book
     * @param ISBN the ISBN of the book
     * @param yearPublished the year the book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the title of the book.
     * 
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     * 
     * @param title the new title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     * 
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * 
     * @param author the new author of the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     * 
     * @return the ISBN of the book
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN of the book.
     * 
     * @param ISBN the new ISBN of the book
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets the year the book was published.
     * 
     * @return the year the book was published
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     * 
     * @param yearPublished the new year the book was published
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Compares this Book object with another object for equality.
     * Two Book objects are considered equal if they have the same ISBN and author.
     * 
     * @param obj the object to compare this Book with
     * @return true if the two books are equal (same ISBN and author), false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Checking if the same instance
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false; // Checking if null or not the same class
        }

        Book book = (Book) obj; // Cast to Book
        return ISBN.equals(book.ISBN) && author.equals(book.author); // Compare ISBN and author
    }

    /**
     * Returns a string representation of the Book object.
     * 
     * @return a string representing the Book object with title, author, ISBN, and publication year
     */
    @Override
    public String toString() {
        return "Title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", ISBN='" + ISBN + '\'' +
               ", yearPublished=" + yearPublished;
    }
}
