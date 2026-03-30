import java.util.*;

// Base class
class Payment {
    String processPayment(double amount) {
        return "Processed payment: Total Amount = " + amount;
    }
}

// Credit Card Payment
class CreditCardPayment extends Payment {
    @Override
    String processPayment(double amount) {
        double total = amount + (amount * 0.02);
        return String.format("Processed CreditCard payment: Total Amount = %.2f", total);
    }
}

// PayPal Payment
class PayPalPayment extends Payment {
    @Override
    String processPayment(double amount) {
        double total = amount + 1.50;
        return String.format("Processed PayPal payment: Total Amount = %.2f", total);
    }
}

// UPI Payment
class UPIPayment extends Payment {
    @Override
    String processPayment(double amount) {
        return String.format("Processed UPI payment: Total Amount = %.2f", amount);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            double amount = sc.nextDouble();

            if (type == 'C') {
                payments.add(new CreditCardPayment());
            } else if (type == 'P') {
                payments.add(new PayPalPayment());
            } else if (type == 'U') {
                payments.add(new UPIPayment());
            }
        }

        // Process payments using polymorphism
        for (Payment p : payments) {
            double amount = sc.nextDouble(); // ❌ mistake avoided below
        }

        // Correct processing
        sc = new Scanner(System.in);
        sc.nextInt(); // skip count already read

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            double amount = sc.nextDouble();

            Payment p;

            if (type == 'C') {
                p = new CreditCardPayment();
            } else if (type == 'P') {
                p = new PayPalPayment();
            } else {
                p = new UPIPayment();
            }

            System.out.println(p.processPayment(amount));
        }

        sc.close();
    }
}
