/**
 * Assignment 5: Library Management System with Fine Calculation
 * Author: Srivattsa
 * Date: 2025-09-01
 *
 * Simple library management system demonstrating OOP concepts and fine calculation.
 */
class Book {
    private String bookId;
    private String title;
    private boolean isIssued;
    private String issueDate;
    private String dueDate;

    private static int totalBooks = 0;

    public Book(String id, String title) {
        this.bookId = id;
        this.title = title;
        this.isIssued = false;
        totalBooks++;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }
}

class Member {
    private String memberId;
    private String memberName;
    private String memberType;
    private Book[] booksIssued;
    private double totalFines;
    private int issuedCount = 0;

    private static int totalMembers = 0;
    private static String libraryName = "Default Library";
    private static double finePerDay = 2.0;
    private static int maxBooksAllowed = 3;

    public Member(String id, String name, String type, String date) {
        this.memberId = id;
        this.memberName = name;
        this.memberType = type;
        this.booksIssued = new Book[maxBooksAllowed];
        totalMembers++;
    }

    public void issueBook(Book book) {
        if (issuedCount < maxBooksAllowed && !book.isIssued()) {
            booksIssued[issuedCount++] = book;
            book.setIssued(true);
            System.out.println("Book issued: " + book.getTitle());
        } else {
            System.out.println("Cannot issue book: Limit reached or already issued.");
        }
    }

    public void returnBook(Book book, int overdueDays) {
        for (int i = 0; i < issuedCount; i++) {
            if (booksIssued[i] == book) {
                booksIssued[i].setIssued(false);
                System.out.println("Book returned: " + book.getTitle());
                if (overdueDays > 0) {
                    double fine = overdueDays * finePerDay;
                    totalFines += fine;
                    System.out.println("Fine for overdue: " + fine);
                }
                // Shift left
                for (int j = i; j < issuedCount - 1; j++) {
                    booksIssued[j] = booksIssued[j+1];
                }
                booksIssued[issuedCount-1] = null;
                issuedCount--;
                return;
            }
        }
        System.out.println("Book not found in issued list.");
    }

    public double getTotalFines() { return totalFines; }
    public static int getTotalMembers() { return totalMembers; }
    public static String getLibraryName() { return libraryName; }
    public static void setLibraryName(String name) { libraryName = name; }
}

public class Assignment5_Srivattsa {
    public static void main(String[] args) {
        Member.setLibraryName("City Library");
        Book b1 = new Book("B1", "Java Basics");
        Book b2 = new Book("B2", "OOP Concepts");
        Book b3 = new Book("B3", "Data Structures");
        Book b4 = new Book("B4", "Algorithms");

        Member m1 = new Member("M1", "Alice", "Student", "2025-01-01");

        m1.issueBook(b1);
        m1.issueBook(b2);
        m1.issueBook(b3);
        m1.issueBook(b4); // Should fail

        m1.returnBook(b1, 2); // 2 days overdue
        m1.returnBook(b2, 0); // No overdue

        System.out.println("Total Fines for Alice: " + m1.getTotalFines());
        System.out.println("Total Members: " + Member.getTotalMembers());
        System.out.println("Library Name: " + Member.getLibraryName());
    }
}
