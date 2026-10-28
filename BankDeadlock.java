class BankAccount {

    int accountNumber;
    int balance;

    BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

public class BankDeadlock {

    static void transfer(BankAccount from, BankAccount to, int amount) {

        BankAccount first;
        BankAccount second;

        if (from.accountNumber < to.accountNumber) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {

                if (from.balance >= amount) {
                    from.balance -= amount;
                    to.balance += amount;

                    System.out.println("Transferred " + amount +
                            " from Account " + from.accountNumber +
                            " to Account " + to.accountNumber);
                } else {
                    System.out.println("Insufficient balance!");
                }
            }
        }
    }

    public static void main(String[] args) {

        BankAccount a = new BankAccount(101, 1000);
        BankAccount b = new BankAccount(102, 1000);

        Thread t1 = new Thread(() -> transfer(a, b, 200));
        Thread t2 = new Thread(() -> transfer(b, a, 300));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Account 101 Balance: " + a.balance);
        System.out.println("Account 102 Balance: " + b.balance);
    }
}