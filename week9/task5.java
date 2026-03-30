import java.util.*;

// Custom Exception
class InsufficientStockException extends Exception {
    InsufficientStockException(String message) {
        super(message);
    }
}

// Order class
class Order {
    int orderId;
    String productName;
    int quantity;
    int availableStock;

    Order(int orderId, String productName, int quantity, int availableStock) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.availableStock = availableStock;
    }

    // Method to process order
    void processOrder() throws InsufficientStockException {
        if (quantity > availableStock) {
            throw new InsufficientStockException("Order " + orderId + " failed: Insufficient stock");
        } else {
            System.out.println("Order " + orderId + " processed successfully");
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String product = sc.next();
            int quantity = sc.nextInt();
            int stock = sc.nextInt();

            Order order = new Order(id, product, quantity, stock);

            try {
                order.processOrder();
            } catch (InsufficientStockException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
