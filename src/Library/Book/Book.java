package Library.Book;

/**
 * Teacher-provided Book class (minimal but complete).
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;

    // Constructor chaining: main constructor
    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Overloaded constructor demonstrates constructor chaining with this()
    public Book(String isbn, String title) {
        this(isbn, title, "Unknown", 0.0);
    }

    // Getters and setters (encapsulation)
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Display method
    public void displayBookInfo() {
        System.out.printf("BOOK -> ISBN: %s | Title: %s | Author: %s | Price: %.2f%n",
                isbn, title, author, price);
    }
}
