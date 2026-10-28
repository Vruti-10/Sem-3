public class Main {

    public static void main(String[] args) {

        AccountStore store = new AccountStore();

        Account account1 = new Account("A101", "Kavya", 5000);
        Account account2 = new Account("A102", "Rahul", 3000);
        Account account3 = new Account("A103", "Amit", 7000);
        Account account4 = new Account("A104", "Priya", 2000);

        store.add(account1);
        store.add(account2);
        store.add(account3);
        store.add(account4);

        System.out.println("All Accounts:");

        for (Account account : store.getAll()) {
            System.out.println(account);
        }

        System.out.println("\nSearch Account A102:");

        Account found = store.get("A102");

        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Account not found");
        }

        System.out.println("\nAccounts Sorted by Balance:");

        for (Account account : store.sortedByBalance()) {
            System.out.println(account);
        }

        System.out.println("\nAccounts Above Balance 3000:");

        for (Account account : store.getAccountsAboveBalance(3000)) {
            System.out.println(account);
        }

        System.out.println("\nAccounts Sorted by Account Number:");

        for (Account account :
                store.getAccountsSortedByNumber().values()) {
            System.out.println(account);
        }

        System.out.println("\nTransaction History:");

        for (String transaction : store.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\nConcurrentHashMap Test:");

        TransactionProcessor processor = new TransactionProcessor();

        processor.addAccount(account1);
        processor.addAccount(account2);
        processor.addAccount(account3);
        processor.addAccount(account4);

        System.out.println(
            processor.getAccount("A101")
        );

        processor.stop();
    }
}