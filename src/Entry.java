import Library.Book.Book;
import Library.Book.ReferenceBook;
import Library.Member.Member;
import Staff.Liberian.Librarian;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Entry.java - main program implementing a menu-driven console app.
 * Use this as the program entry point.
 */
public class Entry {
    private static final Scanner scanner = new Scanner(System.in);

    // Collections to store objects
    private static final ArrayList<Book> books = new ArrayList<>();
    private static final ArrayList<ReferenceBook> refBooks = new ArrayList<>();
    private static final ArrayList<Member> members = new ArrayList<>();
    private static final ArrayList<Librarian> librarians = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> addReferenceBook();
                    case 3 -> addMember();
                    case 4 -> addLibrarian();
                    case 5 -> displayBooksMenu();
                    case 6 -> displayRefBooksMenu();
                    case 7 -> displayAllMembers();
                    case 8 -> displayAllLibrarians();
                    case 9 -> {
                        System.out.println("Exiting program. Goodbye!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please choose 1-9.");
                }
            } catch (InputMismatchException ime) {
                // Handles entering text instead of number
                System.out.println("Input error: please enter numbers where required. (" + ime.getMessage() + ")");
                scanner.nextLine(); // clear bad input
            } catch (ArrayIndexOutOfBoundsException aibe) {
                System.out.println("Index error: you tried to access a non-existing item. (" + aibe.getMessage() + ")");
            } catch (Exception e) {
                // Generic catch-all to prevent crash and meet assignment requirement
                System.out.println("Unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
            }
            System.out.println(); // blank line for readability
        }
    }

    private static void displayMenu() {
        System.out.println("========= LIBRARY MANAGEMENT SYSTEM =========");
        System.out.println("1)  Add Book");
        System.out.println("2)  Add Reference Book");
        System.out.println("3)  Add Member");
        System.out.println("4)  Add Librarian");
        System.out.println("5)  Display Book Information");
        System.out.println("6)  Display Reference Book Information");
        System.out.println("7)  Display All Members");
        System.out.println("8)  Display All Librarians");
        System.out.println("9)  Exit");
        System.out.println("=============================================");
    }

    private static void addBook() {
        System.out.println("--- Add Book ---");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        double price = 0.0;
        try {
            System.out.print("Enter Price: ");
            price = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("Price must be a number. Using 0.0 as default.");
            scanner.nextLine();
        }
        Book b = new Book(isbn, title, author, price);
        books.add(b);
        System.out.println("Book added successfully.");
    }

    private static void addReferenceBook() {
        System.out.println("--- Add Reference Book ---");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        double price = 0.0;
        try {
            System.out.print("Enter Price: ");
            price = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("Price must be a number. Using 0.0 as default.");
            scanner.nextLine();
        }
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();
        ReferenceBook rb = new ReferenceBook(isbn, title, author, price, subject);
        refBooks.add(rb);
        System.out.println("Reference book added successfully.");
    }

    private static void addMember() {
        System.out.println("--- Add Member ---");
        try {
            System.out.print("Enter Member ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            Member m = new Member(id, name, phone, email);
            members.add(m);
            System.out.println("Member added successfully.");
        } catch (InputMismatchException ime) {
            System.out.println("Member ID must be an integer.");
            scanner.nextLine();
        }
    }

    private static void addLibrarian() {
        System.out.println("--- Add Librarian ---");
        try {
            System.out.print("Enter Librarian ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Shift (Day/Night): ");
            String shift = scanner.nextLine();
            Librarian l = new Librarian(id, name, shift);
            librarians.add(l);
            System.out.println("Librarian added successfully.");
        } catch (InputMismatchException ime) {
            System.out.println("Librarian ID must be an integer.");
            scanner.nextLine();
        }
    }

    // Menus to display books with option to view all or by index (demonstrates ArrayIndexOutOfBoundsException)
    private static void displayBooksMenu() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("--- Display Book Information ---");
        System.out.println("1) Display all books");
        System.out.println("2) Display book by index (0-based)");
        System.out.print("Choose option: ");
        try {
            int opt = scanner.nextInt();
            scanner.nextLine();
            if (opt == 1) {
                for (Book b : books) b.displayBookInfo();
            } else if (opt == 2) {
                System.out.print("Enter index (0 to " + (books.size()-1) + "): ");
                int idx = scanner.nextInt();
                scanner.nextLine();
                books.get(idx).displayBookInfo(); // may throw ArrayIndexOutOfBoundsException
            } else {
                System.out.println("Invalid option.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private static void displayRefBooksMenu() {
        if (refBooks.isEmpty()) {
            System.out.println("No reference books available.");
            return;
        }
        System.out.println("--- Display Reference Book Information ---");
        System.out.println("1) Display all reference books");
        System.out.println("2) Display reference book by index (0-based)");
        System.out.print("Choose option: ");
        try {
            int opt = scanner.nextInt();
            scanner.nextLine();
            if (opt == 1) {
                for (ReferenceBook rb : refBooks) rb.displayBookInfo();
            } else if (opt == 2) {
                System.out.print("Enter index (0 to " + (refBooks.size()-1) + "): ");
                int idx = scanner.nextInt();
                scanner.nextLine();
                refBooks.get(idx).displayBookInfo(); // may throw ArrayIndexOutOfBoundsException
            } else {
                System.out.println("Invalid option.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private static void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        System.out.println("--- All Members ---");
        for (Member m : members) m.displayMemberInfo();
    }

    private static void displayAllLibrarians() {
        if (librarians.isEmpty()) {
            System.out.println("No librarians registered.");
            return;
        }
        System.out.println("--- All Librarians ---");
        for (Librarian l : librarians) l.displayLibrarianInfo();
    }
}
