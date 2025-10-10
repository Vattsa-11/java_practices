import java.util.HashSet;

class Employee {
    private String empCode;
    private String name;
    
    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }
    
    // Override equals() - same empCode means same employee
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return empCode.equals(employee.empCode);
    }
    
    // Override hashCode() based on empCode
    @Override
    public int hashCode() {
        return empCode.hashCode();
    }
    
    // toString() showing both fields
    @Override
    public String toString() {
        return "Employee{empCode='" + empCode + "', name='" + name + "'}";
    }
}

public class Q2_EmployeeAuth {
    public static void main(String[] args) {
        // 1. Employee e1
        Employee e1 = new Employee("BL001", "Ritika");
        
        // 2. Employee e2
        Employee e2 = new Employee("BL001", "Ritika S.");
        
        // 3. Compare using == and equals()
        System.out.println("e1 == e2: " + (e1 == e2));
        System.out.println("e1.equals(e2): " + e1.equals(e2));
        
        // 4. Test using HashSet
        HashSet<Employee> empSet = new HashSet<>();
        empSet.add(e1);
        empSet.add(e2);
        
        System.out.println("\nHashSet size: " + empSet.size());
        System.out.println("HashSet contains: " + empSet);
    }
}
