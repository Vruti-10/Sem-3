import exception.*;

public class Main {

    public static void main(String[] args) {

        MiniBank bank = new MiniBank();

        Account account1 =
                new Account(
                        "A101",
                        "Kavya",
                        1000
                );

        Account account2 =
                new Account(
                        "A102",
                        "Rahul",
                        500
                );

        bank.addAccount(account1);
        bank.addAccount(account2);

        System.out.println("\n--- Account Details ---");

        account1.display();

        System.out.println();

        account2.display();

        System.out.println(
                "\n--- Deposit Test ---"
        );

        try {

            account1.deposit(500);

            System.out.println(
                    "New balance: "
                    + account1.getBalance()
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Error: "
                    + e.getMessage()
            );
        }
        System.out.println(
                "\n--- Withdrawal Test ---"
        );

        try {

            account1.withdraw(5000);

        } catch (InsufficientFundsException e) {

            System.out.println(
                    "Error: "
                    + e.getMessage()
            );

            System.out.println(
                    "Shortfall: "
                    + e.getShortfall()
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Error: "
                    + e.getMessage()
            );
        }
        System.out.println(
                "\n--- Transfer Test ---"
        );

        try {

            bank.transfer(
                    account1,
                    account2,
                    300
            );

        } catch (BankException e) {

            System.out.println(
                    "Transfer failed: "
                    + e.getMessage()
            );
        }

        System.out.println(
                "\n--- Account Search Test ---"
        );

        try {

            bank.findAccount("A999");

        } catch (AccountNotFoundException e) {

            System.out.println(
                    "Error: "
                    + e.getMessage()
            );
        }
        System.out.println(
                "\n--- Try With Resources ---"
        );

        try (BankResource resource =
                     new BankResource()) {

            resource.process();

        } catch (Exception e) {

            System.out.println(
                    "Error: "
                    + e.getMessage()
            );

        } finally {

            System.out.println(
                    "Bank operation finished."
            );
        }
    }
}