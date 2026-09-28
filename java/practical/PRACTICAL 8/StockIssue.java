import java.util.*;

class OutOfStockException extends Exception {

    private int shortfall;

    public OutOfStockException(int shortfall) {
        super("Not enough stock. Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {

    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {

    private Map<String, Integer> stock = new HashMap<>();

    public Warehouse() {
        stock.put("Laptop", 10);
        stock.put("Mouse", 20);
        stock.put("Keyboard", 15);
    }

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero."
            );
        }

        if (!stock.containsKey(item)) {
            throw new OutOfStockException(qty);
        }

        int available = stock.get(item);

        if (qty > available) {
            int shortfall = qty - available;
            throw new OutOfStockException(shortfall);
        }

        stock.put(item, available - qty);

        System.out.println(
                qty + " " + item + "(s) issued successfully."
        );
    }
}

public class StockIssue {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        String[] items = {
                "Laptop",
                "Mouse",
                "Keyboard",
                "Laptop"
        };

        int[] quantities = {
                3,
                25,
                -2,
                20
        };

        for (int i = 0; i < items.length; i++) {

            try {

                System.out.println(
                        "Request: " +
                        items[i] +
                        " - " +
                        quantities[i]
                );

                warehouse.issue(items[i], quantities[i]);

            } catch (OutOfStockException e) {

                System.out.println(
                        "Out of stock. Shortfall = "
                        + e.getShortfall()
                );

            } catch (InvalidQuantityException e) {

                System.out.println(
                        "Invalid quantity: "
                        + e.getMessage()
                );
            }

            System.out.println();
        }
    }
}