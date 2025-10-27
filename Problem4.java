package basic;

import java.io.*;
import java.util.Scanner;

public class Problem4 {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("===================================");
        System.out.println("       Simple Notes Manager");
        System.out.println("===================================");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes App. Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    // Method to add a note (write to file)
    private static void addNote(Scanner sc) {
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to view notes (read from file)
    private static void viewNotes() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No notes found. Add a note first.");
            return;
        }

        System.out.println("\n--- Your Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

