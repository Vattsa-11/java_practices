// Practice Problem 4: JavaBean Standards Implementation
import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}
    public EmployeeBean(String employeeId, String firstName, String lastName, double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary);
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String id) { this.employeeId = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String name) { this.firstName = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String name) { this.lastName = name; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { if (salary >= 0) this.salary = salary; }
    public String getDepartment() { return department; }
    public void setDepartment(String dept) { this.department = dept; }
    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date date) { this.hireDate = date; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
    // Computed properties
    public String getFullName() { return firstName + " " + lastName; }
    public int getYearsOfService() {
        if (hireDate == null) return 0;
        Calendar start = Calendar.getInstance();
        start.setTime(hireDate);
        Calendar now = Calendar.getInstance();
        int years = now.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) < start.get(Calendar.DAY_OF_YEAR)) years--;
        return years;
    }
    public String getFormattedSalary() {
        return String.format("$%,.2f", salary);
    }
    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ", 2);
        if (parts.length == 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        }
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("ID: %s, Name: %s, Salary: %s, Dept: %s, Hire: %s, Active: %b", employeeId, getFullName(), getFormattedSalary(), department, hireDate != null ? sdf.format(hireDate) : "N/A", isActive);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean e = (EmployeeBean) o;
        return Objects.equals(employeeId, e.employeeId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
    public static void main(String[] args) {
        EmployeeBean e1 = new EmployeeBean();
        e1.setEmployeeId("E001");
        e1.setFullName("Alice Smith");
        e1.setSalary(50000);
        e1.setDepartment("IT");
        e1.setHireDate(new Date());
        e1.setActive(true);
        EmployeeBean e2 = new EmployeeBean("E002", "Bob", "Jones", 60000, "HR", new Date(), false);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println("Years of Service: " + e2.getYearsOfService());
        System.out.println("Full Name: " + e2.getFullName());
    }
}

class JavaBeanProcessor {
    public static void printAllProperties(EmployeeBean emp) {
        try {
            for (java.lang.reflect.Method m : emp.getClass().getMethods()) {
                if (m.getName().startsWith("get") || m.getName().startsWith("is")) {
                    System.out.println(m.getName() + ": " + m.invoke(emp));
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
    public static void copyProperties(EmployeeBean source, EmployeeBean target) {
        try {
            for (java.lang.reflect.Method m : source.getClass().getMethods()) {
                if (m.getName().startsWith("get") && m.getParameterCount() == 0) {
                    String prop = m.getName().substring(3);
                    try {
                        java.lang.reflect.Method setter = target.getClass().getMethod("set" + prop, m.getReturnType());
                        setter.invoke(target, m.invoke(source));
                    } catch (NoSuchMethodException ignore) {}
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
