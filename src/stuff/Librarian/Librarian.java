package Staff.Liberian;

/**
 * Librarian module with constructor chaining and display method.
 */
public class Librarian {
    private int librarianId;
    private String name;
    private String shift;

    // Full constructor
    public Librarian(int librarianId, String name, String shift) {
        this.librarianId = librarianId;
        this.name = name;
        this.shift = shift;
    }

    // Constructor chaining example
    public Librarian(int librarianId, String name) {
        this(librarianId, name, "Day"); // default shift
    }

    // Getters and setters
    public int getLibrarianId() { return librarianId; }
    public void setLibrarianId(int librarianId) { this.librarianId = librarianId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }

    public void displayLibrarianInfo() {
        System.out.printf("LIBRARIAN -> ID: %d | Name: %s | Shift: %s%n",
                librarianId, name, shift);
    }
}
