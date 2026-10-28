public class Driver {

    public static void main(String[] args) {

        
        Customer.Address address =
                new Customer.Address(
                        "101 Main Road",
                        "Ahmedabad",
                        "380001"
                );

    
        Customer customer =
                new Customer(
                        "Kavya",
                        "kavya@gmail.com",
                        "9876543210",
                        address
                );

        
        Account account1 =
                new Account("A101", "Kavya", 5000);

        Account account2 =
                new Account("A102", "Rahul", 7000);

        Account account3 =
                new Account("A101", "Kavya", 9000);

   
        System.out.println(account1);
        System.out.println(account2);

        
        System.out.println("account1 equals account2: "
                + account1.equals(account2));

        System.out.println("account1 equals account3: "
                + account1.equals(account3));

     
        System.out.println(
                "account1 is Account: "
                + (account1 instanceof Account)
        );

        System.out.println(
                "customer is Customer: "
                + (customer instanceof Customer)
        );

        System.out.println("City: "
                + customer.getAddress().getCity());

        System.out.println("Pincode: "
                + customer.getAddress().getPincode());

        s
        Customer copy = customer.clone();

        System.out.println("Customer cloned successfully: "
                + (copy != null));
    }
}