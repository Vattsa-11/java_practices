class AppConfig {
    private String appName;
    
    public AppConfig(String appName) {
        this.appName = appName;
    }
    
    // Static Nested Class
    public static class NetworkConfig {
        private String host;
        private int port;
        
        public NetworkConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }
        
        // Display network config
        public void displayConfig() {
            System.out.println("Network Config - Host: " + host + ", Port: " + port);
        }
    }
}

public class Q6_AppConfigurator {
    public static void main(String[] args) {
        // Create instance of NetworkConfig, print details
        AppConfig.NetworkConfig networkConfig = new AppConfig.NetworkConfig("localhost", 8080);
        networkConfig.displayConfig();
        
        AppConfig.NetworkConfig prodConfig = new AppConfig.NetworkConfig("prod.server.com", 443);
        prodConfig.displayConfig();
    }
}
