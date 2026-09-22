package Project;


import java.util.Objects;

// ================= ACCOUNT CLASS =================
class Account {
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    // toString()
    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | " + balance;
    }

    // equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Account)) {
            return false;
        }

        Account other = (Account) o;

        return accountNumber.equals(other.accountNumber);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}


// ================= CUSTOMER CLASS =================
class Customer implements Cloneable {

    private String name;
    private String email;
    private String mobile;
    private final String customerId;

    private Address address;

    public Customer(String customerId, String name,
                    String email, String mobile) {

        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    // ================= ADDRESS CLASS =================
    public static class Address {

        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }

        @Override
        public String toString() {
            return line + ", " + city + " - " + pincode;
        }
    }

    // Set address
    public void setAddress(Address address) {
        this.address = address;
    }

    // Get address
    public Address getAddress() {
        return address;
    }

    // clone()
    @Override
    public Customer clone() {
        try {
            return (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return customerId + " | " + name + " | "
                + email + " | " + mobile;
    }
}


// ================= MAIN CLASS =================
public class MiniBank3 {

    public static void main(String[] args) {

        // Create first account
        Account a1 = new Account(
                "AC0001",
                "Riya",
                4000
        );

        // Create second account with same account number
        Account a2 = new Account(
                "AC0001",
                "Riya",
                5000
        );

        // Print accounts
        System.out.println("Account 1: " + a1);
        System.out.println("Account 2: " + a2);

        // Compare accounts
        System.out.println("a1 equals a2: " + a1.equals(a2));

        // instanceof
        System.out.println(
                "a1 instanceof Account: "
                + (a1 instanceof Account)
        );


        // Create Customer
        Customer customer = new Customer(
                "CUST101",
                "Riya",
                "riya@gmail.com",
                "9876543210"
        );


        // Create Address
        Customer.Address address =
                new Customer.Address(
                        "123 Main Road",
                        "Vadodara",
                        "390001"
                );


        // Add address to customer
        customer.setAddress(address);

        // Print customer
        System.out.println();
        System.out.println("Customer:");
        System.out.println(customer);

        // Print address
        System.out.println("Address: "
                + customer.getAddress());


        // Clone customer
        Customer copy = customer.clone();

        System.out.println();
        System.out.println("Cloned Customer:");
        System.out.println(copy);

        // Check instanceof
        System.out.println(
                "copy instanceof Customer: "
                + (copy instanceof Customer)
        );
    }
}