// Problem 5: Movie Streaming Platform - Downcasting
import java.util.*;

class Content {
    protected String title;
    protected String genre;
    protected double rating;
    protected int releaseYear;
    
    public Content(String title, String genre, double rating, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    
    public void play() {
        System.out.println("▶️ Now playing: " + title);
    }
    
    public void displayBasicInfo() {
        System.out.println("Title: " + title + " | Genre: " + genre + " | Rating: " + rating + "/10 | Year: " + releaseYear);
    }
}

class Movie extends Content {
    private int durationMinutes;
    private String director;
    private boolean hasSubtitles;
    private String ageRating; // G, PG, PG-13, R
    
    public Movie(String title, String genre, double rating, int releaseYear, 
                 int duration, String director, boolean hasSubtitles, String ageRating) {
        super(title, genre, rating, releaseYear);
        this.durationMinutes = duration;
        this.director = director;
        this.hasSubtitles = hasSubtitles;
        this.ageRating = ageRating;
    }
    
    @Override
    public void play() {
        System.out.println("🎬 Playing movie: " + title);
        System.out.println("   Duration: " + durationMinutes + " minutes");
        System.out.println("   Director: " + director);
        System.out.println("   Age Rating: " + ageRating);
    }
    
    // Movie-specific methods
    public void showSubtitleOptions() {
        if (hasSubtitles) {
            System.out.println("📝 Subtitle options: English, Spanish, French, German");
        } else {
            System.out.println("❌ No subtitles available for this movie");
        }
    }
    
    public void showMovieDetails() {
        System.out.println("🎥 MOVIE DETAILS:");
        System.out.println("   Runtime: " + durationMinutes + " min (" + (durationMinutes/60) + "h " + (durationMinutes%60) + "m)");
        System.out.println("   Directed by: " + director);
        System.out.println("   Rated: " + ageRating);
        System.out.println("   Subtitles: " + (hasSubtitles ? "Available" : "Not Available"));
    }
    
    public int getDuration() { return durationMinutes; }
    public String getDirector() { return director; }
    public String getAgeRating() { return ageRating; }
}

class TVSeries extends Content {
    private int seasons;
    private int totalEpisodes;
    private int currentSeason;
    private int currentEpisode;
    private boolean isCompleted;
    
    public TVSeries(String title, String genre, double rating, int releaseYear,
                    int seasons, int totalEpisodes, boolean isCompleted) {
        super(title, genre, rating, releaseYear);
        this.seasons = seasons;
        this.totalEpisodes = totalEpisodes;
        this.currentSeason = 1;
        this.currentEpisode = 1;
        this.isCompleted = isCompleted;
    }
    
    @Override
    public void play() {
        System.out.println("📺 Playing TV Series: " + title);
        System.out.println("   Season " + currentSeason + ", Episode " + currentEpisode);
        System.out.println("   Total: " + seasons + " seasons, " + totalEpisodes + " episodes");
    }
    
    // TV Series-specific methods
    public void showNextEpisodeSuggestion() {
        if (currentSeason <= seasons && currentEpisode < totalEpisodes) {
            int nextEpisode = currentEpisode + 1;
            int nextSeason = currentSeason;
            
            // Assume 10 episodes per season for simplicity
            if (nextEpisode > 10) {
                nextEpisode = 1;
                nextSeason++;
            }
            
            if (nextSeason <= seasons) {
                System.out.println("⏭️ Up Next: Season " + nextSeason + ", Episode " + nextEpisode);
                System.out.println("   Auto-play in 10 seconds...");
            } else {
                System.out.println("✅ You've reached the end of the series!");
            }
        }
    }
    
    public void showSeriesProgress() {
        int watchedEpisodes = (currentSeason - 1) * 10 + currentEpisode;
        double progress = (watchedEpisodes / (double) totalEpisodes) * 100;
        System.out.println("📊 SERIES PROGRESS:");
        System.out.println("   Current: S" + currentSeason + "E" + currentEpisode);
        System.out.println("   Progress: " + String.format("%.1f", progress) + "% complete");
        System.out.println("   Status: " + (isCompleted ? "Series Completed" : "Still Airing"));
    }
    
    public void selectEpisode(int season, int episode) {
        if (season <= seasons && episode <= 10) {
            this.currentSeason = season;
            this.currentEpisode = episode;
            System.out.println("📍 Jumped to Season " + season + ", Episode " + episode);
        }
    }
    
    public int getSeasons() { return seasons; }
    public int getTotalEpisodes() { return totalEpisodes; }
}

class Documentary extends Content {
    private String narrator;
    private String topic;
    private String educationalLevel; // Beginner, Intermediate, Advanced
    private List<String> relatedTopics;
    
    public Documentary(String title, String genre, double rating, int releaseYear,
                      String narrator, String topic, String educationalLevel) {
        super(title, genre, rating, releaseYear);
        this.narrator = narrator;
        this.topic = topic;
        this.educationalLevel = educationalLevel;
        this.relatedTopics = new ArrayList<>();
    }
    
    @Override
    public void play() {
        System.out.println("🎓 Playing Documentary: " + title);
        System.out.println("   Topic: " + topic);
        System.out.println("   Narrated by: " + narrator);
        System.out.println("   Educational Level: " + educationalLevel);
    }
    
    // Documentary-specific methods
    public void showEducationalTags() {
        System.out.println("🏷️ EDUCATIONAL TAGS:");
        System.out.println("   Primary Topic: " + topic);
        System.out.println("   Difficulty: " + educationalLevel);
        System.out.println("   Learning Objective: Understanding " + topic + " concepts");
        System.out.println("   Target Audience: " + educationalLevel + " level learners");
    }
    
    public void showRelatedContent() {
        System.out.println("🔗 RELATED DOCUMENTARIES:");
        if (relatedTopics.isEmpty()) {
            // Generate some related topics based on the main topic
            if (topic.toLowerCase().contains("nature")) {
                relatedTopics.addAll(Arrays.asList("Wildlife Conservation", "Climate Change", "Ocean Life"));
            } else if (topic.toLowerCase().contains("history")) {
                relatedTopics.addAll(Arrays.asList("Ancient Civilizations", "World Wars", "Cultural Heritage"));
            } else if (topic.toLowerCase().contains("science")) {
                relatedTopics.addAll(Arrays.asList("Space Exploration", "Medical Breakthroughs", "Technology"));
            } else {
                relatedTopics.addAll(Arrays.asList("Similar Educational Content", "Expert Interviews", "Case Studies"));
            }
        }
        for (String topic : relatedTopics) {
            System.out.println("   • " + topic + " documentaries");
        }
    }
    
    public void addRelatedTopic(String topic) {
        relatedTopics.add(topic);
    }
    
    public String getNarrator() { return narrator; }
    public String getTopic() { return topic; }
    public String getEducationalLevel() { return educationalLevel; }
}

public class Problem5 {
    public static void main(String[] args) {
        System.out.println("=== Movie Streaming Platform - Downcasting Demo ===\n");
        
        // Create a mixed content library using upcasting
        Content[] library = {
            new Movie("Avengers: Endgame", "Action", 8.4, 2019, 181, "Russo Brothers", true, "PG-13"),
            new TVSeries("Breaking Bad", "Drama", 9.5, 2008, 5, 62, true),
            new Documentary("Planet Earth", "Nature", 9.4, 2006, "David Attenborough", "Nature", "Beginner"),
            new Movie("The Godfather", "Crime", 9.2, 1972, 175, "Francis Ford Coppola", true, "R"),
            new TVSeries("Stranger Things", "Sci-Fi", 8.7, 2016, 4, 42, false),
            new Documentary("Free Solo", "Adventure", 8.2, 2018, "Peter Sarsgaard", "Rock Climbing", "Intermediate")
        };
        
        System.out.println("=== Content Library Overview ===");
        for (Content content : library) {
            content.displayBasicInfo();
        }
        System.out.println();
        
        System.out.println("=== Now Playing - Basic Polymorphism ===");
        for (Content content : library) {
            content.play(); // Polymorphic behavior
            System.out.println();
        }
        
        System.out.println("=== Accessing Specific Features - Downcasting ===");
        for (Content content : library) {
            System.out.println("Processing: " + content.title);
            
            // Downcasting to access specific features
            if (content instanceof Movie) {
                // Downcast to Movie to access movie-specific features
                Movie movie = (Movie) content;
                movie.showMovieDetails();
                movie.showSubtitleOptions();
                
                // Example of using specific movie features
                if (movie.getDuration() > 180) {
                    System.out.println("⚠️ Long movie alert! Consider taking a break.");
                }
                
            } else if (content instanceof TVSeries) {
                // Downcast to TVSeries to access series-specific features
                TVSeries series = (TVSeries) content;
                series.showSeriesProgress();
                series.showNextEpisodeSuggestion();
                
                // Example of using specific series features
                if (series.getSeasons() > 3) {
                    System.out.println("📚 Binge-worthy series with lots of content!");
                }
                
            } else if (content instanceof Documentary) {
                // Downcast to Documentary to access documentary-specific features
                Documentary doc = (Documentary) content;
                doc.showEducationalTags();
                doc.showRelatedContent();
                
                // Example of using specific documentary features
                if (doc.getEducationalLevel().equals("Advanced")) {
                    System.out.println("🎓 Advanced content - may require background knowledge.");
                }
            }
            
            System.out.println("─".repeat(60));
        }
        
        System.out.println("\n=== Interactive User Experience Demo ===");
        // Simulate user selecting specific content and accessing unique features
        Content userSelection = library[1]; // Breaking Bad (TV Series)
        
        System.out.println("User selected: " + userSelection.title);
        userSelection.play();
        
        // User wants to jump to a specific episode - need to downcast
        if (userSelection instanceof TVSeries) {
            TVSeries selectedSeries = (TVSeries) userSelection;
            selectedSeries.selectEpisode(3, 7); // Jump to Season 3, Episode 7
            selectedSeries.showSeriesProgress();
        }
        
        System.out.println("\n=== Content Recommendation Engine ===");
        // Example of processing mixed content safely
        for (Content content : library) {
            System.out.print("Recommending: " + content.title + " - ");
            
            if (content instanceof Movie) {
                Movie m = (Movie) content;
                System.out.println("Great " + m.getAgeRating() + " rated movie by " + m.getDirector());
            } else if (content instanceof TVSeries) {
                TVSeries s = (TVSeries) content;
                System.out.println("Binge-worthy series with " + s.getSeasons() + " seasons!");
            } else if (content instanceof Documentary) {
                Documentary d = (Documentary) content;
                System.out.println("Educational content about " + d.getTopic() + " - " + d.getEducationalLevel() + " level");
            }
        }
        
        System.out.println("\n🎯 Downcasting Demo Complete!");
        System.out.println("We safely converted general Content references to specific types");
        System.out.println("to access unique features like subtitles, episode selection, and educational tags!");
    }
}