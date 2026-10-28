import java.util.*;
import exception.*;

public class MiniBank {

    private Map<String, Account> accounts =
            new HashMap<>();

    public void addAccount(Account account) {

        accounts.put(
                account.getAccountNumber(),
                account
        );

        System.out.println(
                "Account added successfully."
        );
    }

    public Account findAccount(String accountNumber)
            throws AccountNotFoundException {

        Account account = accounts.get(accountNumber);

        if (account == null) {

            throw new AccountNotFoundException(
                    "Account not found: "
                    + accountNumber
            );
        }

        return account;
    }

    public void transfer(
            Account from,
            Account to,
            long amount)
            throws BankException {

        try {

            from.withdraw(amount);

            to.deposit(amount);

            System.out.println(
                    "Transfer successful."
            );

        } catch (InvalidAmountException |
                 InsufficientFundsException e) {

            throw e;

        } finally {

            System.out.println(
                    "Transfer operation completed."
            );
        }
    }
}