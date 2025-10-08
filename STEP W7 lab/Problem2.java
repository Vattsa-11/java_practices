// Problem 2: Social Media Feed - Method Overriding
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Base Post class with common information
class Post {
    protected String author;
    protected String content;
    protected LocalDateTime timestamp;
    protected int likes;
    protected int shares;
    
    public Post(String author, String content) {
        this.author = author;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.likes = 0;
        this.shares = 0;
    }
    
    // Method to be overridden by each platform
    public void displayPost() {
        System.out.println("Generic Post by " + author);
        System.out.println("Content: " + content);
        System.out.println("Posted: " + timestamp.format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm")));
    }
    
    // Common methods for all posts
    public void like() {
        likes++;
        System.out.println("👍 Post liked! Total likes: " + likes);
    }
    
    public void share() {
        shares++;
        System.out.println("🔄 Post shared! Total shares: " + shares);
    }
    
    // Getters
    public String getAuthor() { return author; }
    public String getContent() { return content; }
    public int getLikes() { return likes; }
    public int getShares() { return shares; }
}

// Instagram Post - focuses on hashtags and visual appeal
class InstagramPost extends Post {
    private List<String> hashtags;
    private boolean hasImage;
    private int comments;
    private String filter;
    
    public InstagramPost(String author, String content, boolean hasImage, String filter) {
        super(author, content);
        this.hasImage = hasImage;
        this.filter = filter;
        this.comments = 0;
        this.hashtags = new ArrayList<>();
        extractHashtags();
    }
    
    private void extractHashtags() {
        String[] words = content.split("\\s+");
        for (String word : words) {
            if (word.startsWith("#")) {
                hashtags.add(word);
            }
        }
    }
    
    @Override
    public void displayPost() {
        System.out.println("📸 INSTAGRAM POST");
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│ @" + author + " • " + timestamp.format(DateTimeFormatter.ofPattern("MMM dd")) + "                     │");
        System.out.println("├─────────────────────────────────────┤");
        
        if (hasImage) {
            System.out.println("│ [📷 Beautiful Image with " + filter + " filter] │");
            System.out.println("├─────────────────────────────────────┤");
        }
        
        System.out.println("│ " + content);
        System.out.println("│                                     │");
        
        if (!hashtags.isEmpty()) {
            System.out.println("│ 🏷️ Tags: " + String.join(" ", hashtags) + "");
            System.out.println("│                                     │");
        }
        
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ ❤️ " + likes + " likes  💬 " + comments + " comments  📤 " + shares + " shares    │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.println("Instagram Focus: Visual storytelling with hashtags and engagement");
    }
    
    public void addComment() {
        comments++;
        System.out.println("💬 New comment added! Total: " + comments);
    }
    
    public void addHashtag(String hashtag) {
        if (!hashtag.startsWith("#")) hashtag = "#" + hashtag;
        hashtags.add(hashtag);
        content += " " + hashtag;
    }
    
    public List<String> getHashtags() { return hashtags; }
}

// Twitter Post - focuses on brevity and retweets
class TwitterPost extends Post {
    private static final int MAX_CHARACTERS = 280;
    private int retweets;
    private int replies;
    private boolean isThread;
    private List<String> mentions;
    
    public TwitterPost(String author, String content) {
        super(author, content);
        this.retweets = 0;
        this.replies = 0;
        this.isThread = false;
        this.mentions = new ArrayList<>();
        
        // Truncate content if too long
        if (content.length() > MAX_CHARACTERS) {
            this.content = content.substring(0, MAX_CHARACTERS - 3) + "...";
        }
        
        extractMentions();
    }
    
    private void extractMentions() {
        String[] words = content.split("\\s+");
        for (String word : words) {
            if (word.startsWith("@")) {
                mentions.add(word);
            }
        }
    }
    
    @Override
    public void displayPost() {
        System.out.println("🐦 TWITTER POST");
        System.out.println("╭─────────────────────────────────────╮");
        System.out.println("│ " + author + " @" + author.toLowerCase().replace(" ", "") + " • " + 
                         timestamp.format(DateTimeFormatter.ofPattern("MMM dd")) + "              │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ " + content);
        System.out.println("│                                     │");
        System.out.println("│ Characters: " + content.length() + "/" + MAX_CHARACTERS + 
                         (isThread ? " (Thread)" : "") + "                   │");
        
        if (!mentions.isEmpty()) {
            System.out.println("│ 👥 Mentions: " + String.join(" ", mentions) + "");
        }
        
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 💬 " + replies + "  🔄 " + retweets + "  ❤️ " + likes + "  📤 " + shares + "             │");
        System.out.println("╰─────────────────────────────────────╯");
        System.out.println("Twitter Focus: Quick thoughts with character limit and retweets");
    }
    
    public void retweet() {
        retweets++;
        System.out.println("🔄 Retweeted! Total retweets: " + retweets);
    }
    
    public void reply() {
        replies++;
        System.out.println("💬 Reply added! Total replies: " + replies);
    }
    
    public void makeThread() {
        isThread = true;
        System.out.println("🧵 Post converted to thread!");
    }
    
    public int getRetweets() { return retweets; }
    public int getCharacterCount() { return content.length(); }
}

// LinkedIn Post - focuses on professional content and networking
class LinkedInPost extends Post {
    private String company;
    private String jobTitle;
    private List<String> skills;
    private int connections;
    private String postType; // "update", "article", "achievement", "job_posting"
    private boolean isProfessional;
    
    public LinkedInPost(String author, String content, String company, String jobTitle, String postType) {
        super(author, content);
        this.company = company;
        this.jobTitle = jobTitle;
        this.postType = postType;
        this.connections = 0;
        this.skills = new ArrayList<>();
        this.isProfessional = true;
        
        // Add some relevant skills based on content
        if (content.toLowerCase().contains("java")) skills.add("Java");
        if (content.toLowerCase().contains("leadership")) skills.add("Leadership");
        if (content.toLowerCase().contains("project")) skills.add("Project Management");
    }
    
    @Override
    public void displayPost() {
        System.out.println("💼 LINKEDIN POST");
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ " + author + "                               ┃");
        System.out.println("┃ " + jobTitle + " at " + company + "");
        System.out.println("┃ • " + timestamp.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")) + 
                         " • " + connections + " connections     ┃");
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        
        // Different display based on post type
        switch (postType.toLowerCase()) {
            case "achievement":
                System.out.println("┃ 🏆 PROFESSIONAL ACHIEVEMENT          ┃");
                break;
            case "article":
                System.out.println("┃ 📝 PROFESSIONAL ARTICLE              ┃");
                break;
            case "job_posting":
                System.out.println("┃ 💼 JOB OPPORTUNITY                   ┃");
                break;
            default:
                System.out.println("┃ 📢 PROFESSIONAL UPDATE               ┃");
        }
        
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("┃ " + content);
        System.out.println("┃                                     ┃");
        
        if (isProfessional) {
            System.out.println("┃ ✓ Professional Content Verified     ┃");
        }
        
        if (!skills.isEmpty()) {
            System.out.println("┃ 🎯 Relevant Skills: " + String.join(", ", skills) + "");
            System.out.println("┃                                     ┃");
        }
        
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("┃ 👍 " + likes + " likes  💬 " + shares + " comments  🤝 " + connections + " connections ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println("LinkedIn Focus: Professional networking and career development");
    }
    
    public void connect() {
        connections++;
        System.out.println("🤝 New professional connection! Total: " + connections);
    }
    
    public void addSkill(String skill) {
        skills.add(skill);
        System.out.println("🎯 Skill added: " + skill);
    }
    
    public void endorse() {
        System.out.println("⭐ Professional endorsement received!");
    }
    
    public String getCompany() { return company; }
    public String getJobTitle() { return jobTitle; }
    public List<String> getSkills() { return skills; }
}

public class Problem2 {
    public static void main(String[] args) {
        System.out.println("=== Social Media Feed - Method Overriding Demo ===\n");
        
        // Create different types of posts (same interface, different behavior)
        List<Post> socialMediaFeed = new ArrayList<>();
        
        // Instagram Posts
        InstagramPost instaPost1 = new InstagramPost("Alice Johnson", 
            "Beautiful sunset at the beach! 🌅 #sunset #beach #photography #blessed", 
            true, "Valencia");
        
        InstagramPost instaPost2 = new InstagramPost("Bob Smith", 
            "My homemade pizza turned out amazing! 🍕 #cooking #homemade #foodie #pizza", 
            true, "Clarendon");
        
        // Twitter Posts
        TwitterPost tweetPost1 = new TwitterPost("Tech Guru", 
            "Just finished reading about the latest Java features. The new pattern matching is incredible! @java #programming #tech");
        
        TwitterPost tweetPost2 = new TwitterPost("News Reporter", 
            "Breaking: Major breakthrough in renewable energy technology announced today. This could change everything! #greenenergy #tech #news");
        
        // LinkedIn Posts
        LinkedInPost linkedPost1 = new LinkedInPost("Sarah Wilson", 
            "Excited to share that our team successfully delivered the Java microservices project ahead of schedule! Great leadership and teamwork made this possible.", 
            "Tech Solutions Inc.", "Senior Software Developer", "achievement");
        
        LinkedInPost linkedPost2 = new LinkedInPost("Mike Chen", 
            "Looking for talented Java developers to join our growing team. We offer remote work, great benefits, and exciting projects!", 
            "StartupXYZ", "Engineering Manager", "job_posting");
        
        // Add all posts to feed
        socialMediaFeed.add(instaPost1);
        socialMediaFeed.add(tweetPost1);
        socialMediaFeed.add(linkedPost1);
        socialMediaFeed.add(instaPost2);
        socialMediaFeed.add(tweetPost2);
        socialMediaFeed.add(linkedPost2);
        
        System.out.println("=== Mixed Social Media Feed Display ===");
        System.out.println("Same method call (displayPost), different platform behaviors!\n");
        
        // Demonstrate method overriding - same method, different behaviors
        for (int i = 0; i < socialMediaFeed.size(); i++) {
            System.out.println("Post " + (i + 1) + ":");
            socialMediaFeed.get(i).displayPost(); // Polymorphic behavior!
            System.out.println();
        }
        
        System.out.println("=== Platform-Specific Interactions ===");
        
        // Instagram specific interactions
        System.out.println("📸 Instagram Interactions:");
        instaPost1.like();
        instaPost1.like();
        instaPost1.addComment();
        instaPost1.addHashtag("nature");
        instaPost1.share();
        System.out.println("Updated Instagram post:");
        instaPost1.displayPost();
        System.out.println();
        
        // Twitter specific interactions
        System.out.println("🐦 Twitter Interactions:");
        tweetPost1.like();
        tweetPost1.retweet();
        tweetPost1.retweet();
        tweetPost1.reply();
        tweetPost1.makeThread();
        System.out.println("Updated Twitter post:");
        tweetPost1.displayPost();
        System.out.println();
        
        // LinkedIn specific interactions
        System.out.println("💼 LinkedIn Interactions:");
        linkedPost1.like();
        linkedPost1.connect();
        linkedPost1.connect();
        linkedPost1.addSkill("Team Leadership");
        linkedPost1.endorse();
        System.out.println("Updated LinkedIn post:");
        linkedPost1.displayPost();
        System.out.println();
        
        System.out.println("=== Cross-Platform Analytics ===");
        System.out.println("Analyzing engagement across different platforms:\n");
        
        for (Post post : socialMediaFeed) {
            System.out.println("Author: " + post.getAuthor());
            System.out.println("Platform: " + post.getClass().getSimpleName().replace("Post", ""));
            System.out.println("Likes: " + post.getLikes() + " | Shares: " + post.getShares());
            
            // Platform-specific metrics (demonstrating safe downcasting)
            if (post instanceof InstagramPost) {
                InstagramPost ig = (InstagramPost) post;
                System.out.println("Hashtags: " + ig.getHashtags().size() + " tags used");
            } else if (post instanceof TwitterPost) {
                TwitterPost tw = (TwitterPost) post;
                System.out.println("Retweets: " + tw.getRetweets() + " | Characters: " + tw.getCharacterCount() + "/280");
            } else if (post instanceof LinkedInPost) {
                LinkedInPost li = (LinkedInPost) post;
                System.out.println("Company: " + li.getCompany() + " | Skills mentioned: " + li.getSkills().size());
            }
            System.out.println("─".repeat(40));
        }
        
        System.out.println("\n🎯 Method Overriding Demo Complete!");
        System.out.println("✅ Same method name (displayPost) across all platforms");
        System.out.println("✅ Each platform customizes display format and information");
        System.out.println("✅ Instagram: Visual focus with hashtags and filters");
        System.out.println("✅ Twitter: Character limits and retweets");
        System.out.println("✅ LinkedIn: Professional formatting and connections");
        System.out.println("✅ Runtime polymorphism - correct method called based on object type");
    }
}