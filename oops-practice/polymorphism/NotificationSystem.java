package polymorphism;

class Notification {
    String recipientName;
    String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public void sendNotification() {
        System.out.println("Sending notification to " + recipientName);
    }
}

class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Email sent to: " + recipientName);
        System.out.println("Message: " + message);
        System.out.println("Channel: Email");
    }
}

class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS sent to: " + recipientName);
        System.out.println("Message: " + message);
        System.out.println("Channel: SMS");
    }
}

class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Push Notification sent to: " + recipientName);
        System.out.println("Message: " + message);
        System.out.println("Channel: Mobile App");
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        // Requirement 1: Store multiple objects in a Notification[] array
        Notification[] notifications = new Notification[3];
        
        // Requirement 2: Take recipient names as strings
        notifications[0] = new EmailNotification("Alice", "Welcome to our platform!");
        notifications[1] = new SMSNotification("Bob", "Your OTP is 1234");
        notifications[2] = new PushNotification("Charlie", "New friend request!");

        System.out.println("--- Sending All Notifications ---");
        // Requirement 3: Use dynamic method dispatch to send notifications
        // Requirement 4: Display all sent notifications
        for (Notification n : notifications) {
            n.sendNotification();
            System.out.println("-------------------------");
        }
    }
}
