interface Notifier {
    void send(String message);
}
interface Urgent {
}
class EmailSender implements Urgent {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
class SMSSender {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
public class NotificationDemo {
    public static void main(String[] args) {
        Notifier email = message ->
                System.out.println("Email: " + message);
        Notifier sms = message ->
                System.out.println("SMS: " + message);
        Notifier[] senders = {
            email,
            sms
        };
        String message = "Your order has been shipped!";
        System.out.println("---- Broadcasting Message ----");
        for (Notifier sender : senders) {
            sender.send(message);
        }
        Notifier urgentEmail = new Notifier() {
            public void send(String message) {
                System.out.println("URGENT Email: " + message);
            }
        };
        System.out.println("\n---- Urgent Notification ----");
        urgentEmail.send(message);
        urgentEmail.send(message);
    }
}