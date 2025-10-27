package basic;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    // Methods
    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    // Display details
    public void displayBook() {
        String status = isIssued ? "Issued" : "Available";
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + status);
    }
}

