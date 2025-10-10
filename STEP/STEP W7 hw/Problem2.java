// PROBLEM 2: Online Learning Platform - Method Overriding

class Course {
    protected String title;
    protected String instructor;
    protected String enrollmentDate;

    public Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    public void displayProgress() {
        System.out.println("\n=== COURSE INFO ===");
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled: " + enrollmentDate);
    }
}

class VideoCourse extends Course {
    private int completionPercentage;
    private int watchTimeMinutes;

    public VideoCourse(String title, String instructor, String enrollmentDate, 
                       int completionPercentage, int watchTimeMinutes) {
        super(title, instructor, enrollmentDate);
        this.completionPercentage = completionPercentage;
        this.watchTimeMinutes = watchTimeMinutes;
    }

    @Override
    public void displayProgress() {
        super.displayProgress();
        System.out.println("Type: Video Course");
        System.out.println("Completion: " + completionPercentage + "%");
        System.out.println("Watch Time: " + watchTimeMinutes + " minutes");
    }
}

class InteractiveCourse extends Course {
    private int quizScore;
    private int projectsCompleted;

    public InteractiveCourse(String title, String instructor, String enrollmentDate,
                            int quizScore, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScore = quizScore;
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public void displayProgress() {
        super.displayProgress();
        System.out.println("Type: Interactive Course");
        System.out.println("Quiz Score: " + quizScore + "%");
        System.out.println("Projects Completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    private int pagesRead;
    private int totalPages;
    private int notesTaken;

    public ReadingCourse(String title, String instructor, String enrollmentDate,
                        int pagesRead, int totalPages, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.totalPages = totalPages;
        this.notesTaken = notesTaken;
    }

    @Override
    public void displayProgress() {
        super.displayProgress();
        System.out.println("Type: Reading Course");
        System.out.println("Pages Read: " + pagesRead + "/" + totalPages);
        System.out.println("Notes Taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    private int examAttempts;
    private String certificationStatus;

    public CertificationCourse(String title, String instructor, String enrollmentDate,
                              int examAttempts, String certificationStatus) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certificationStatus = certificationStatus;
    }

    @Override
    public void displayProgress() {
        super.displayProgress();
        System.out.println("Type: Certification Course");
        System.out.println("Exam Attempts: " + examAttempts);
        System.out.println("Certification Status: " + certificationStatus);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Course[] courses = new Course[4];
        
        courses[0] = new VideoCourse("Java Programming", "John Doe", "2025-01-15", 75, 450);
        courses[1] = new InteractiveCourse("Web Development", "Jane Smith", "2025-02-01", 88, 5);
        courses[2] = new ReadingCourse("Data Structures", "Bob Johnson", "2025-03-10", 120, 200, 15);
        courses[3] = new CertificationCourse("AWS Certified", "Alice Brown", "2025-04-05", 2, "Certified");
        
        for (Course course : courses) {
            course.displayProgress();
        }
    }
}
