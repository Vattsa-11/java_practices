// Practice Problem 4: University System - Upcasting Adventures
// File: UniversitySystem.java

class Person {
    protected String name;
    protected int age;
    protected String email;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Introduction method
    public void introduce() {
        System.out.println("Hi! I'm " + name + ", " + age + " years old.");
    }
    
    // Contact information method
    public void getContactInfo() {
        System.out.println("Email: " + email);
    }
}

class Student extends Person {
    private String studentId;
    private String major;
    
    public Student(String name, int age, String email, String studentId, String major) {
        super(name, age, email);
        this.studentId = studentId;
        this.major = major;
    }
    
    // Student-specific method
    public void attendLecture() {
        System.out.println(name + " is attending " + major + " lecture");
    }
    
    // Student-specific method
    public void submitAssignment() {
        System.out.println("Assignment submitted by " + studentId);
    }
}

class Professor extends Person {
    private String department;
    
    public Professor(String name, int age, String email, String department) {
        super(name, age, email);
        this.department = department;
    }
    
    // Professor-specific method
    public void conductClass() {
        System.out.println("Prof. " + name + " is teaching " + department);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        System.out.println("=== University Registration Demo ===");
        
        // Create Student object
        Student alice = new Student("Alice", 20, "alice@uni.edu", "CS2021", "Computer Science");
        
        System.out.println("\n👩‍🎓 Direct Student access:");
        alice.introduce();
        alice.getContactInfo();
        alice.attendLecture();
        alice.submitAssignment();
        
        System.out.println("\n⬆️ Upcasting Student to Person reference:");
        // Upcast Student to Person reference - SAFE and AUTOMATIC
        Person p = alice; // or: Person p = new Student(...);
        
        p.introduce();        // Works - inherited method
        p.getContactInfo();   // Works - inherited method
        System.out.println("Name accessed through Person reference: " + p.name); // Works - inherited field
        
        // This would cause COMPILE ERROR - Person doesn't know about Student methods
        // p.attendLecture();    // ❌ Compile error
        // p.submitAssignment(); // ❌ Compile error
        
        System.out.println("\n🎓 Testing with Professor:");
        Professor prof = new Professor("Dr. Smith", 45, "smith@uni.edu", "Computer Science");
        Person personRef = prof; // Upcasting Professor to Person
        
        personRef.introduce();
        personRef.getContactInfo();
        // personRef.conductClass(); // ❌ Would cause compile error
        
        System.out.println("\n=== Why Upcasting is Safe but Limiting: ===");
        System.out.println("✅ SAFE: Child objects always have all parent features");
        System.out.println("⚠️ LIMITING: Parent reference can't access child-specific methods");
        System.out.println("🧠 COMPILE-TIME: Method availability checked at compile time");
        System.out.println("📚 USE CASE: Treating different objects uniformly (polymorphism)");
    }
}