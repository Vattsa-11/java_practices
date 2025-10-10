public class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    // Default constructor
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // Parameterized constructor
    public GameController(String controllerBrand, String connectionType, boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = (batteryLevel < 0) ? 0 : (batteryLevel > 100 ? 100 : batteryLevel);
        this.sensitivity = (sensitivity < 0.1) ? 0.1 : (sensitivity > 3.0 ? 3.0 : sensitivity);
    }

    // Two-parameter convenience constructor
    public GameController(String brand, String connectionType) {
        this(brand, connectionType, true, 100, 1.0);
    }

    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Yes" : "No"));
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");
        GameController c1 = new GameController();
        GameController c2 = new GameController("ProPad", "Bluetooth", false, 80, 2.5);
        GameController c3 = new GameController("LitePad", "Wireless");

        System.out.println("\nDefault Controller:");
        c1.displayConfiguration();
        c1.calibrateController();
        c1.testVibration();

        System.out.println("\nCustom Controller:");
        c2.displayConfiguration();
        c2.calibrateController();
        c2.testVibration();

        System.out.println("\nConvenience Controller:");
        c3.displayConfiguration();
        c3.calibrateController();
        c3.testVibration();
    }
}
