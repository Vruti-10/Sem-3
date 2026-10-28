import java.util.*;

public class AccountStore {

    private HashMap<String, Account> accounts = new HashMap<>();

    private ArrayList<String> transactionHistory = new ArrayList<>();

    public void add(Account account) {
        accounts.put(account.getAccountNumber(), account);
        transactionHistory.add(
            "Account added: " + account.getAccountNumber()
        );
    }

    public Account get(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public ArrayList<Account> getAll() {
        return new ArrayList<>(accounts.values());
    }

    public ArrayList<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public ArrayList<Account> sortedByBalance() {
        ArrayList<Account> list = getAll();

        list.sort(
            Comparator.comparingLong(Account::getBalance)
        );

        return list;
    }

    public ArrayList<Account> getAccountsAboveBalance(long amount) {
        ArrayList<Account> result = new ArrayList<>();

        for (Account account : accounts.values()) {
            if (account.getBalance() > amount) {
                result.add(account);
            }
        }

        return result;
    }

    public TreeMap<String, Account> getAccountsSortedByNumber() {
        return new TreeMap<>(accounts);
    }
}