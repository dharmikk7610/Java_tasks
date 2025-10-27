package basic;

import java.util.Scanner;

public class Problem1 {

    // Method to add 
    static double add(double a, double b) {
        return a + b;
    }

    // Method to subtract
    static double subtract(double a, double b) {
        return a - b;
    }

    // Method to multiply 
    static double multiply(double a, double b) {
        return a * b;
    }

    // Method to divide  (check for division by zero)
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println(" Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {

        // Create Scanner object to get user input
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("--->> Welcome to the Java Calculator--->>");
        System.out.println("==================================");

        Boolean flag = true;

             while (flag) {

            //  menu options
            System.out.println("\nChoose an operation:");
            System.out.println("1. Addition ");
            System.out.println("2. Subtraction ");
            System.out.println("3. Multiplication ");
            System.out.println("4. Division ");
            System.out.println("5. Exit");
            System.out.print("--->>Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println(" >>Thank you for using the calculator!");
                break;
            }

            // Get two numbers from user
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            double result = 0;

            
            if (choice == 1) {
                result = add(num1, num2);
                System.out.println(" Result = " + result);
            } else if (choice == 2) {
                result = subtract(num1, num2);
                System.out.println(" Result = " + result);
            } else if (choice == 3) {
                result = multiply(num1, num2);
                System.out.println(" Result = " + result);
            } else if (choice == 4) {
                result = divide(num1, num2);
                System.out.println(" Result = " + result);
            } else {
                System.out.println("  please try again!");
            }
        }

     
      
    }
}
