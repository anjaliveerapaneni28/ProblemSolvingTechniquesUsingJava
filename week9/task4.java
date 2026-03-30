import java.util.*;

// Interface
interface Notification {
    void sendNotification(String message);
}

// Email Notification
class EmailNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Email notification: " + message);
    }
}

// SMS Notification
class SMSNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent SMS notification: " + message);
    }
}

// Push Notification
class PushNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Push notification: " + message);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            String message = sc.next();

            Notification notification;

            if (type == 'E') {
                notification = new EmailNotification();
            } else if (type == 'S') {
                notification = new SMSNotification();
            } else {
                notification = new PushNotification();
            }

            // Interface-based call
            notification.sendNotification(message);
        }

        sc.close();
    }
}
