package org.howard.edu.lsp.midterm.question2;

public class Book {

    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    
    //constructor 
    
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

  
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true; // Checking if the same instance
        }
        System.out.println(obj);
        if (obj == null || getClass() != obj.getClass()) {
        	return false; // Checking if null or not the same class
        }

        Book book = (Book) obj; // Cast to Book
        return ISBN.equals(book.ISBN) && author.equals(book.author); // Compare ISBN and author
    }

    // Override toString method
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}