interface Notifier {
    void send(String message);
}

class Service {
    public void triggerAlert() {
        // Create Notifier instance using anonymous inner class
        Notifier notifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("ALERT: " + message);
            }
        };
        
        notifier.send("System maintenance scheduled at 2 AM");
        notifier.send("New security update available");
    }
}

public class Q8_NotificationService {
    public static void main(String[] args) {
        new Service().triggerAlert();
    }
}
