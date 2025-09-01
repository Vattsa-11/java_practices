/**
 * Assignment 6: Employee Payroll and Attendance System
 * Author: Srivattsa
 * Date: 2025-09-01
 *
 * Simple employee management system demonstrating payroll, attendance, and performance tracking.
 */
class Employee {
    private String empName;
    private String department;
    private String designation;
    private double baseSalary;
    private boolean[] attendanceRecord;
    private String type;

    private static String companyName = "Default Company";
    private static double totalSalaryExpense = 0.0;
    private static int workingDaysPerMonth = 30;

    public Employee(String name, String dept, String desig, double salary, String type) {
        this.empName = name;
        this.department = dept;
        this.designation = desig;
        this.baseSalary = salary;
        this.type = type;
        this.attendanceRecord = new boolean[workingDaysPerMonth];
    }

    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= workingDaysPerMonth) attendanceRecord[day-1] = present;
    }

    public double calculateSalary() {
        int presentDays = 0;
        for (boolean present : attendanceRecord) if (present) presentDays++;
        double salary = baseSalary * presentDays / workingDaysPerMonth;
        if (type.equals("Full-time")) salary += calculateBonus();
        totalSalaryExpense += salary;
        return salary;
    }

    public double calculateBonus() {
        // Simple bonus: 10% of base salary if all days present
        int presentDays = 0;
        for (boolean present : attendanceRecord) if (present) presentDays++;
        if (presentDays == workingDaysPerMonth) return baseSalary * 0.1;
        return 0.0;
    }

    public void generatePaySlip() {
        System.out.println("--- Pay Slip for " + empName + " ---");
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("Bonus: " + calculateBonus());
        System.out.println();
    }

    public void requestLeave(int day) {
        if (day >= 1 && day <= workingDaysPerMonth) attendanceRecord[day-1] = false;
        System.out.println(empName + " requested leave on day " + day);
    }

    public static double calculateCompanyPayroll() { return totalSalaryExpense; }
    // Removed getTotalEmployees()
    public static String getCompanyName() { return companyName; }
    public static void setCompanyName(String name) { companyName = name; }
}

public class Assignment6_Srivattsa {
    public static void main(String[] args) {
        Employee.setCompanyName("Tech Solutions");
    Employee e1 = new Employee("Alice", "IT", "Developer", 30000, "Full-time");
    Employee e2 = new Employee("Bob", "HR", "Manager", 25000, "Part-time");

        // Mark attendance
        for (int i = 1; i <= 30; i++) e1.markAttendance(i, true);
        for (int i = 1; i <= 20; i++) e2.markAttendance(i, true);
        for (int i = 21; i <= 30; i++) e2.markAttendance(i, false);

        e1.generatePaySlip();
        e2.generatePaySlip();

        e2.requestLeave(15);

    // Removed print for total employees
        System.out.println("Company Name: " + Employee.getCompanyName());
        System.out.println("Total Salary Expense: " + Employee.calculateCompanyPayroll());
    }
}
