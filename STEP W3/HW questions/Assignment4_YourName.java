/**
 * Assignment 4: Student Grade Management System
 * Author: YourName
 * Date: 2025-09-01
 *
 * Simple student grade management system demonstrating static vs instance members and data processing.
 */
class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    public Subject(String code, String name, int credits, String instructor) {
        this.subjectCode = code;
        this.subjectName = name;
        this.credits = credits;
        this.instructor = instructor;
    }
    public String getSubjectCode() { return subjectCode; }
    public String getSubjectName() { return subjectName; }
}

class Student {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks;
    private double gpa;

    private static int totalStudents = 0;
    private static String schoolName = "Default School";
    private static String[] gradingScale = {"A", "B", "C", "D", "F"};
    private static double passPercentage = 40.0;

    public Student(String id, String name, String className, String[] subjects) {
        this.studentId = id;
        this.studentName = name;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length][1];
        totalStudents++;
    }

    public void addMarks(String subject, double mark) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                marks[i][0] = mark;
                break;
            }
        }
    }

    public void calculateGPA() {
        double total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i][0];
        }
        gpa = total / marks.length;
    }

    public void generateReportCard() {
        System.out.println("--- Report Card for " + studentName + " ---");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i][0] + "% Grade: " + getGrade(marks[i][0]));
        }
        System.out.println("GPA: " + gpa);
        System.out.println("Promotion Eligible: " + checkPromotionEligibility());
        System.out.println();
    }

    public boolean checkPromotionEligibility() {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i][0] < passPercentage) return false;
        }
        return true;
    }

    private String getGrade(double percentage) {
        if (percentage >= 90) return gradingScale[0];
        else if (percentage >= 80) return gradingScale[1];
        else if (percentage >= 70) return gradingScale[2];
        else if (percentage >= 50) return gradingScale[3];
        else return gradingScale[4];
    }

    public static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }

    public static double calculateClassAverage(Student[] students) {
        double total = 0;
        for (Student s : students) {
            total += s.gpa;
        }
        return total / students.length;
    }

    public static Student[] getTopPerformers(Student[] students, int count) {
        Student[] sorted = students.clone();
        java.util.Arrays.sort(sorted, (a, b) -> Double.compare(b.gpa, a.gpa));
        Student[] top = new Student[Math.min(count, sorted.length)];
        System.arraycopy(sorted, 0, top, 0, top.length);
        return top;
    }

    public static void generateSchoolReport(Student[] students) {
        System.out.println("School: " + schoolName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Class Average GPA: " + calculateClassAverage(students));
        Student[] top = getTopPerformers(students, 3);
        System.out.println("Top Performers:");
        for (Student s : top) {
            System.out.println(s.studentName + " GPA: " + s.gpa);
        }
        System.out.println();
    }

    public static void setSchoolName(String name) { schoolName = name; }
    public static int getTotalStudents() { return totalStudents; }
}

public class Assignment4_YourName {
    public static void main(String[] args) {
        Student.setSchoolName("Future School");
        String[] subjects = {"Math", "Science", "English"};
        Student s1 = new Student("S1", "Alice", "10A", subjects);
        Student s2 = new Student("S2", "Bob", "10A", subjects);
        Student s3 = new Student("S3", "Charlie", "10A", subjects);

        s1.addMarks("Math", 95);
        s1.addMarks("Science", 88);
        s1.addMarks("English", 92);
        s1.calculateGPA();
        s1.generateReportCard();

        s2.addMarks("Math", 75);
        s2.addMarks("Science", 65);
        s2.addMarks("English", 70);
        s2.calculateGPA();
        s2.generateReportCard();

        s3.addMarks("Math", 45);
        s3.addMarks("Science", 55);
        s3.addMarks("English", 60);
        s3.calculateGPA();
        s3.generateReportCard();

        Student[] students = {s1, s2, s3};
        Student.generateSchoolReport(students);
    }
}
