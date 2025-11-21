package Library.Book;

/**
 * ReferenceBook extends Book and overrides the display method.
 */
public class ReferenceBook extends Book {
    private String subject;

    public ReferenceBook(String isbn, String title, String author, double price, String subject) {
        super(isbn, title, author, price);
        this.subject = subject;
    }

    // Constructor chaining example (uses super)
    public ReferenceBook(String isbn, String title, String subject) {
        super(isbn, title); // calls Book(String, String)
        this.subject = subject;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    // Overriding display method
    @Override
    public void displayBookInfo() {
        System.out.printf("REF BOOK -> ISBN: %s | Title: %s | Subject: %s | Author: %s | Price: %.2f%n",
                getIsbn(), getTitle(), subject, getAuthor(), getPrice());
    }
}
