// Practice Problem 2: Social Media Platform - Method Overriding
// File: SocialMediaDemo.java

class SocialMediaPost {
    protected String content;
    protected String author;
    
    public SocialMediaPost(String content, String author) {
        this.content = content;
        this.author = author;
    }
    
    // Base share method
    public void share() {
        System.out.println("Sharing: " + content + " by " + author);
    }
}

class InstagramPost extends SocialMediaPost {
    private int likes;
    
    public InstagramPost(String content, String author, int likes) {
        super(content, author);
        this.likes = likes;
    }
    
    // Override share method for Instagram
    @Override
    public void share() {
        System.out.println("📸 Instagram: " + content + " by @" + author + " - " + likes + " likes ❤️");
    }
}

class TwitterPost extends SocialMediaPost {
    private int retweets;
    
    public TwitterPost(String content, String author, int retweets) {
        super(content, author);
        this.retweets = retweets;
    }
    
    // Override share method for Twitter
    @Override
    public void share() {
        System.out.println("🐦 Tweet: " + content + " by @" + author + " - " + retweets + " retweets 🔄");
    }
}

public class SocialMediaDemo {
    public static void main(String[] args) {
        System.out.println("=== Social Media Feed Simulation ===");
        
        // Create array of SocialMediaPost references
        SocialMediaPost[] feed = new SocialMediaPost[3];
        
        // Add different types of posts
        feed[0] = new InstagramPost("Sunset vibes!", "john_doe", 245);
        feed[1] = new TwitterPost("Java is awesome!", "code_ninja", 89);
        feed[2] = new SocialMediaPost("Hello world!", "beginner");
        
        // Loop through and call share() on each - observe different behaviors!
        System.out.println("\n📱 Your Social Media Feed:");
        for (int i = 0; i < feed.length; i++) {
            System.out.println("\nPost " + (i + 1) + ":");
            feed[i].share(); // Runtime polymorphism in action!
        }
        
        System.out.println("\n=== Each object type calls its own share() method! ===");
    }
}