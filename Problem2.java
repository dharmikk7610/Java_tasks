package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student1> studentList = new ArrayList<>();
        boolean running = true;

        System.out.println("=====================================");
        System.out.println("-->> Student Record Management System");
        System.out.println("=====================================");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("-->> Enter your choice:--> ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Add Student
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = sc.nextDouble();

                    studentList.add(new Student1(id, name, marks));
                    System.out.println("-->> Student added successfully!");
                    break;

                case 2:
                    // View Students
                    if (studentList.isEmpty()) {
                        System.out.println(" No student records found!");
                    } else {
                        System.out.println("\n Student List:");
                        for (Student1 s : studentList) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    // Update Student
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;

                    for (Student1 s : studentList) {
                        if (s.getId() == updateId) {
                            sc.nextLine(); // consume newline
                            System.out.print("Enter new name: ");
                            s.setName(sc.nextLine());
                            System.out.print("Enter new marks: ");
                            s.setMarks(sc.nextDouble());
                            System.out.println("✅ Student record updated!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ Student not found!");
                    }
                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    Student1 toRemove = null;

                    for (Student1 s : studentList) {
                        if (s.getId() == deleteId) {
                            toRemove = s;
                            break;
                        }
                    }

                    if (toRemove != null) {
                        studentList.remove(toRemove);
                        System.out.println(" Student deleted successfully!");
                    } else {
                        System.out.println(" Student not found!");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println(" Exiting the system..>>");
                    running = false;
                    break;

                default:
                    System.out.println("-->> Invalid choice! Please try again.");
                    break;
            }
        }

       
    }
}

