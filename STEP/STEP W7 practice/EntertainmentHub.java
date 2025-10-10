// Practice Problem 5: Entertainment System - Mastering Downcasting
// File: EntertainmentHub.java

class Entertainment {
    protected String title;
    
    public Entertainment(String title) {
        this.title = title;
    }
    
    // Start entertainment
    public void start() {
        System.out.println("Starting " + title);
    }
    
    // Stop entertainment
    public void stop() {
        System.out.println("Stopping " + title);
    }
}

class Movie extends Entertainment {
    private String genre;
    
    public Movie(String title, String genre) {
        super(title);
        this.genre = genre;
    }
    
    // Movie-specific method
    public void showSubtitles() {
        System.out.println("Showing subtitles for " + title + " (" + genre + ")");
    }
    
    // Movie-specific method
    public void adjustQuality() {
        System.out.println("Adjusting video quality for " + title);
    }
}

class Game extends Entertainment {
    private String platform;
    
    public Game(String title, String platform) {
        super(title);
        this.platform = platform;
    }
    
    // Game-specific method
    public void saveProgress() {
        System.out.println("Saving " + title + " progress on " + platform);
    }
    
    // Game-specific method
    public void showLeaderboard() {
        System.out.println(title + " leaderboard on " + platform);
    }
}

public class EntertainmentHub {
    public static void main(String[] args) {
        System.out.println("=== Entertainment Center Simulation ===");
        
        System.out.println("\n🎬 Movie Entertainment:");
        // Create Entertainment reference and assign Movie object
        Entertainment entertainment = new Movie("Avengers", "Action");
        entertainment.start(); // Works - inherited method
        
        // Downcast Entertainment reference to Movie - EXPLICIT CASTING REQUIRED
        Movie movie = (Movie) entertainment;
        movie.showSubtitles();   // Now we can access Movie-specific methods
        movie.adjustQuality();
        entertainment.stop();
        
        System.out.println("\n🎮 Game Entertainment:");
        // Repeat with Game
        entertainment = new Game("FIFA 24", "PlayStation");
        entertainment.start(); // Works - inherited method
        
        // Downcast to Game
        Game game = (Game) entertainment;
        game.saveProgress();     // Access Game-specific methods
        game.showLeaderboard();
        entertainment.stop();
        
        System.out.println("\n⚠️ Demonstrating Wrong Downcast (Dangerous!):");
        try {
            // This is dangerous - we're trying to cast a Game to Movie
            entertainment = new Game("Call of Duty", "PC");
            
            // This will compile but throw ClassCastException at runtime!
            Movie wrongCast = (Movie) entertainment; // 💥 Runtime error!
            wrongCast.showSubtitles();
            
        } catch (ClassCastException e) {
            System.out.println("❌ ClassCastException caught: " + e.getMessage());
            System.out.println("🚨 Cannot cast Game to Movie - they're different types!");
        }
        
        System.out.println("\n=== Downcasting Rules: ===");
        System.out.println("✅ EXPLICIT: Must use (ChildClass) syntax");
        System.out.println("⚠️ RISKY: Can cause ClassCastException at runtime");
        System.out.println("🎯 PURPOSE: Access subclass-specific methods and fields");
        System.out.println("🛡️ SAFETY: Use instanceof to check before casting (next problem!)");
    }
}