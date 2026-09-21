package Project;

import java.util.Scanner;

// Record
record BankInfo(String name, String branch) {
}

// Enum
enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    WORKING_HOURS,
    EXIT
}

// Main class
public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Bank information
        BankInfo bank = new BankInfo("MiniBank", "CHARUSAT");

        // Header
        System.out.println("================================");
        System.out.println("          " + bank.name());
        System.out.println("          " + bank.branch());
        System.out.println("================================");

        boolean running = true;

        while (running) {

            // Display menu
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Working Hours");
            System.out.println("6. Exit");
            System.out.println("==========================");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            // Switch expression
            String message = switch (choice) {

                case 1 -> "Open Account - to be implemented in a later lab";

                case 2 -> "Deposit - to be implemented in a later lab";

                case 3 -> "Withdraw - to be implemented in a later lab";

                case 4 -> "Transfer - to be implemented in a later lab";

                case 5 -> "Working Hours: Monday to Saturday, 9 AM to 5 PM";

                case 6 -> "Goodbye! Thank you for using MiniBank.";

                default -> "Invalid choice! Please enter a number from 1 to 6.";
            };

            System.out.println(message);

            // Stop program when user chooses 6
            if (choice == 6) {
                running = false;
            }
        }

        sc.close();
    }
}
