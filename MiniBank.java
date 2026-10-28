class Account {
    int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount +
                " | Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount +
                    " | Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class MiniBank {

    public static void main(String[] args) {

        TransactionProcessor processor = new TransactionProcessor();
        Account account = new Account();

        processor.submit(() -> account.deposit(500));
        processor.submit(() -> account.withdraw(200));
        processor.submit(() -> account.deposit(300));
        processor.submit(() -> account.withdraw(400));
        processor.submit(() -> account.deposit(100));
        processor.submit(() -> account.withdraw(150));

        processor.stop();

        System.out.println("Final Balance: " + account.balance);
        System.out.println("All transactions completed.");
    }
}