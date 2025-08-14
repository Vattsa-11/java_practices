public class Q4 {
    static class Movie {
        private 
        String title;
        String genre;
        double rating;

        public 
        Movie(String t, String g, double r) {
            title = t;
            genre = g;
            rating = r;
        }

        void displayDetails() {
            System.out.printf("Title: %s\nGenre: %s\nRating: %.2f", title, genre, rating);
        }
    }

    public static void main(String[] args) {
        Movie m1 = new Movie("Inception", "Sci-Fi", 8.8);
        m1.displayDetails();
    }       
}
