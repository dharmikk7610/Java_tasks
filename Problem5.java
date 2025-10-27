package basic  ;
import java.util.Scanner;

class Account {
    String name;
    double balance;

    // Constructor
    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Check balance
    void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(name, balance);

        int choice = 0;

        // Simple menu using while loop
        while (choice != 4) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double amt = sc.nextDouble();
                acc.deposit(amt);
            } else if (choice == 2) {
                System.out.print("Enter withdraw amount: ");
                double amt = sc.nextDouble();
                acc.withdraw(amt);
            } else if (choice == 3) {
                acc.checkBalance();
            } else if (choice == 4) {
                System.out.println("Thank you! Visit again.");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        
    }
}
