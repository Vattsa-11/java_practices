public class Q5 {

    static class Student {
        private
        int rollNo;
        String name;
        double marks;

        public 
        Student(int rollNo, String name, double marks) {
            this.rollNo = rollNo;
            this.name = name;
            this.marks = marks;
        }
        void display() {
            System.out.printf("Roll No: %d\nName: %s\nMarks: %.2f" ,rollNo, name, marks);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice", 85.5);
        Student student2 = new Student(2, "Bob", 90.0);

        System.out.println("Student 1 Info:");
        student1.display();
        
        System.out.println("\nStudent 2 Info:");
        student2.display();
    }
}