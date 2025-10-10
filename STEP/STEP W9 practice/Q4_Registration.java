class ContactInfo implements Cloneable {
    String email;
    String phone;
    
    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "ContactInfo{email='" + email + "', phone='" + phone + "'}";
    }
}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;
    
    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    // Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // Deep copy
    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) this.contact.clone();
        return cloned;
    }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', contact=" + contact + "}";
    }
}

public class Q4_Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 1. Register student
        ContactInfo contact = new ContactInfo("john@example.com", "1234567890");
        Student s1 = new Student("S001", "John", contact);
        
        // Shallow clone
        Student s2 = (Student) s1.clone();
        System.out.println("Original: " + s1);
        System.out.println("Shallow Clone: " + s2);
        
        // Change contact in shallow clone
        s2.contact.email = "john.new@example.com";
        System.out.println("\nAfter changing email in shallow clone:");
        System.out.println("Original: " + s1);
        System.out.println("Shallow Clone: " + s2);
        
        // Deep clone
        Student s3 = s1.deepClone();
        s3.contact.email = "john.deep@example.com";
        System.out.println("\nAfter changing email in deep clone:");
        System.out.println("Original: " + s1);
        System.out.println("Deep Clone: " + s3);
    }
}
