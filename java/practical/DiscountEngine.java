import java.util.*;
@FunctionalInterface
interface DiscountRule {
    double apply(double price);
}
public class DiscountEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> prices = Arrays.asList(
            500.0,
            1000.0,
            1500.0,
            2000.0
        );
        System.out.println("===== DISCOUNT ENGINE =====");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Flat Rs.100 Discount");
        System.out.println("4. No Discount");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        DiscountRule rule;
        switch (choice) {
            case 1:
                rule = price -> price * 0.90;
                break;
            case 2:
                // 20% discount
                rule = price -> price * 0.80;
                break;
            case 3:
                rule = price -> price - 100;
                break;
            case 4:
                rule = price -> price;
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }
        System.out.println("\n===== FINAL PRICES =====");
 // Apply selected discount to every price
        for (double price : prices) {
            double finalPrice = rule.apply(price);
            System.out.println(
                "Original Price: Rs." + price +
                "  ->  Final Price: Rs." + finalPrice
            );
        }
        sc.close();
    }
}
