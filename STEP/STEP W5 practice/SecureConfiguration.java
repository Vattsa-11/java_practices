// Practice Problem 7: Final Fields and Advanced Encapsulation
import java.util.*;
import java.time.LocalDateTime;

public class SecureConfiguration {
    // Compile-time constants
    public static final String APPLICATION_NAME = "MyApp";
    public static final String VERSION = "1.0";
    public static final int MAX_CONNECTIONS = 100;
    public static final long DEFAULT_TIMEOUT = 5000L;
    // Instance constants
    private final String configId;
    private final LocalDateTime creationTime;
    private final Set<String> allowedOperations;
    // Final references to mutable objects
    private final Map<String, String> serverSettings;
    private final List<String> userPermissions;
    private final Properties securityRules;
    // Complex final fields
    private final byte[] encryptedData;
    private final long checksum;
    // Constructor
    public SecureConfiguration(String configId, Set<String> allowedOps, Map<String, String> settings, List<String> permissions, Properties rules, String sensitiveData) {
        this.configId = configId;
        this.creationTime = LocalDateTime.now();
        this.allowedOperations = new HashSet<>(allowedOps);
        this.serverSettings = new HashMap<>(settings);
        this.userPermissions = new ArrayList<>(permissions);
        this.securityRules = new Properties();
        this.securityRules.putAll(rules);
        this.encryptedData = encryptSensitiveData(sensitiveData);
        this.checksum = calculateChecksum();
    }
    private byte[] encryptSensitiveData(String data) {
        return data != null ? data.getBytes() : new byte[0];
    }
    private long calculateChecksum() {
        return configId.hashCode() + allowedOperations.hashCode() + serverSettings.hashCode() + userPermissions.hashCode() + securityRules.hashCode();
    }
    // Getters
    public String getConfigId() { return configId; }
    public LocalDateTime getCreationTime() { return creationTime; }
    public Set<String> getAllowedOperations() { return new HashSet<>(allowedOperations); }
    public Map<String, String> getServerSettings() { return new HashMap<>(serverSettings); }
    public List<String> getUserPermissions() { return new ArrayList<>(userPermissions); }
    public Properties getSecurityRules() { Properties p = new Properties(); p.putAll(securityRules); return p; }
    public boolean isValid() { return calculateChecksum() == checksum; }
    public long getConfigAge() { return java.time.Duration.between(creationTime, LocalDateTime.now()).toSeconds(); }
    public boolean hasPermission(String permission) { return userPermissions.contains(permission); }
    public String getSettingValue(String key, String defaultValue) { return serverSettings.getOrDefault(key, defaultValue); }
    // Controlled modification
    public void addUserPermission(String permission) { if (!userPermissions.contains(permission)) userPermissions.add(permission); }
    public void removeUserPermission(String permission) { userPermissions.remove(permission); }
    public void updateServerSetting(String key, String value) { serverSettings.put(key, value); }
    public void addSecurityRule(String rule, String value) { securityRules.setProperty(rule, value); }
    public boolean validateIntegrity() { return isValid(); }
    public boolean validatePermission(String operation) { return allowedOperations.contains(operation); }
    public boolean validateChecksum() { return isValid(); }
    public SecureConfiguration createSnapshot() {
        return new SecureConfiguration(configId, allowedOperations, serverSettings, userPermissions, securityRules, new String(encryptedData));
    }
    public Map<String, String> exportSettings() { return new HashMap<>(serverSettings); }
    public static SecureConfiguration createDefaultConfig() {
        Set<String> ops = new HashSet<>(Arrays.asList("read", "write"));
        Map<String, String> settings = new HashMap<>();
        settings.put("host", "localhost");
        settings.put("port", "8080");
        List<String> perms = Arrays.asList("READ", "WRITE");
        Properties rules = new Properties();
        rules.setProperty("encryption", "AES");
        return new SecureConfiguration(UUID.randomUUID().toString(), ops, settings, perms, rules, "secret");
    }
    public static void main(String[] args) {
        Map<String, String> settings = new HashMap<>();
        settings.put("host", "localhost");
        settings.put("port", "8080");
        List<String> permissions = Arrays.asList("READ", "WRITE", "DELETE");
        Set<String> operations = new HashSet<>(Arrays.asList("backup", "restore"));
        Properties rules = new Properties();
        rules.setProperty("encryption", "AES");
        SecureConfiguration config = new SecureConfiguration("cfg1", operations, settings, permissions, rules, "sensitive");
        System.out.println("Config ID: " + config.getConfigId());
        System.out.println("Permissions: " + config.getUserPermissions());
        System.out.println("Server Settings: " + config.getServerSettings());
        System.out.println("Is Valid: " + config.isValid());
        config.addUserPermission("EXECUTE");
        config.updateServerSetting("host", "127.0.0.1");
        System.out.println("Updated Settings: " + config.getServerSettings());
        System.out.println("Snapshot: " + config.createSnapshot().getServerSettings());
    }
}
