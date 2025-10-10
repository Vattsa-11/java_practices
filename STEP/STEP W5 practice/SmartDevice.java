// Practice Problem 5: Read-Only and Write-Only Properties
import java.time.LocalDateTime;
import java.util.UUID;

public class SmartDevice {
    // Read-only
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;
    // Write-only
    private int hashedEncryptionKey;
    private int hashedAdminPassword;
    // Read-write
    private String deviceName;
    private boolean isEnabled;
    // Computed
    private final LocalDateTime startupTime;

    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now();
        this.serialNumber = "SN-" + UUID.randomUUID().toString().substring(0, 8);
        this.deviceName = deviceName;
        this.isEnabled = true;
        this.startupTime = LocalDateTime.now();
    }
    // Read-only getters
    public String getDeviceId() { return deviceId; }
    public LocalDateTime getManufacturingDate() { return manufacturingDate; }
    public String getSerialNumber() { return serialNumber; }
    public long getUptime() {
        return java.time.Duration.between(startupTime, LocalDateTime.now()).getSeconds();
    }
    public int getDeviceAge() {
        return java.time.LocalDate.now().getYear() - manufacturingDate.getYear();
    }
    // Write-only setters
    public void setEncryptionKey(String key) {
        if (key != null && key.length() >= 8) hashedEncryptionKey = key.hashCode();
    }
    public void setAdminPassword(String password) {
        if (password != null && password.length() >= 8) hashedAdminPassword = password.hashCode();
    }
    public boolean validateEncryptionKey(String key) {
        return key != null && key.hashCode() == hashedEncryptionKey;
    }
    public boolean validateAdminPassword(String password) {
        return password != null && password.hashCode() == hashedAdminPassword;
    }
    // Read-write
    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String name) { this.deviceName = name; }
    public boolean isEnabled() { return isEnabled; }
    public void setEnabled(boolean enabled) { this.isEnabled = enabled; }
    public void resetDevice() {
        hashedEncryptionKey = 0;
        hashedAdminPassword = 0;
    }
    public static void main(String[] args) {
        SmartDevice d1 = new SmartDevice("Router");
        System.out.println("ID: " + d1.getDeviceId());
        System.out.println("Serial: " + d1.getSerialNumber());
        System.out.println("Uptime: " + d1.getUptime() + "s");
        d1.setEncryptionKey("supersecret");
        d1.setAdminPassword("adminpass");
        System.out.println("Encryption Key Valid: " + d1.validateEncryptionKey("supersecret"));
        System.out.println("Admin Password Valid: " + d1.validateAdminPassword("adminpass"));
        d1.setDeviceName("NewRouter");
        d1.setEnabled(false);
        System.out.println("Device Name: " + d1.getDeviceName());
        System.out.println("Enabled: " + d1.isEnabled());
    }
}
