package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Method to add a book
    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println(" Book added successfully!");
    }

    // Method to view all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books available in the library!");
        } else {
            System.out.println("\n Book List:");
            for (Book b : books) {
                b.displayBook();
            }
        }
    }

    // Method to add user
    public void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();

        users.add(new User(id, name));
        System.out.println(" User registered successfully!");
    }

    // Method to issue a book
    public void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int bookId = sc.nextInt();
        System.out.print("Enter User ID who wants to issue: ");
        int userId = sc.nextInt();

        Book selectedBook = null;
        for (Book b : books) {
            if (b.getId() == bookId) {
                selectedBook = b;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("❌ Book not found!");
            return;
        }

        if (selectedBook.isIssued()) {
            System.out.println("--> Book is already issued to someone else!");
            return;
        }

        boolean userExists = false;
        for (User u : users) {
            if (u.getUserId() == userId) {
                userExists = true;
                selectedBook.issue();
                System.out.println(" Book issued successfully to " + u.getName() + "!");
                break;
            }
        }

        if (!userExists) {
            System.out.println(" User not found!");
        }
    }

    // Method to return a book
    public void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int bookId = sc.nextInt();

        for (Book b : books) {
            if (b.getId() == bookId) {
                if (!b.isIssued()) {
                    System.out.println("-->> This book was not issued!");
                } else {
                    b.returnBook();
                    System.out.println("Book returned successfully!");
                }
                return;
            }
        }

        System.out.println(" Book not found!");
    }

    // Main menu
    public void startLibrarySystem() {
        boolean running = true;
        System.out.println("=====================================");
        System.out.println("-- Welcome to Library Management System");
        System.out.println("=====================================");

        while (running) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("👉 Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: addUser(); break;
                case 4: issueBook(); break;
                case 5: returnBook(); break;
                case 6:
                    System.out.println("Exiting Library System");
                    running = false;
                    break;
                default:
                    System.out.println(">>> Try again.");
            }
        }
    }

   
    public static void main(String[] args) {
       Problem3 library = new Problem3();
        library.startLibrarySystem();
    }
}
