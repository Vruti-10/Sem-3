import exception.*;

public class Account {

    private String accountNumber;
    private String name;
    private long balance;

    public Account(
            String accountNumber,
            String name,
            long balance) {

        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        System.out.println(
                "Deposited: " + amount
        );
    }

    public void withdraw(long amount)
            throws InsufficientFundsException,
                   InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {

            long shortfall = amount - balance;

            throw new InsufficientFundsException(
                    "Insufficient funds.",
                    shortfall
            );
        }

        balance -= amount;

        System.out.println(
                "Withdrawn: " + amount
        );
    }

    public void display() {

        System.out.println(
                "Account Number: " + accountNumber
        );

        System.out.println(
                "Name: " + name
        );

        System.out.println(
                "Balance: " + balance
        );
    }
}
