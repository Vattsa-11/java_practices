import java.util.Date;

class Employee {
    protected String employeeId;
    protected String name;
    protected double baseSalary;
    protected String department;
    protected Date joiningDate;
    
    public Employee(String employeeId, String name, double baseSalary, String department) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = department;
        this.joiningDate = new Date();
        
        System.out.println("Employee " + name + " created in " + department);
    }
    
    public double calculateSalary() {
        return baseSalary;
    }
    
    public String getJobDescription() {
        return "General Employee";
    }
    
    public void performWork() {
        System.out.println("Employee is working");
    }
    
    public void attendMeeting() {
        System.out.println("Employee attending meeting");
    }
    
    public final String getEmployeeId() {
        return employeeId;
    }
    
    public final void printEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Job: " + getJobDescription());
        System.out.println("Salary: $" + calculateSalary());
        System.out.println("Joined: " + joiningDate);
    }
    
    public void takeBreak() {
        System.out.println("Taking a standard break");
    }
    
    public void clockIn() {
        System.out.println("Clocked in at " + new Date());
    }
    
    public void clockOut() {
        System.out.println("Clocked out at " + new Date());
    }
}

class Developer extends Employee {
    private String[] programmingLanguages;
    private String experienceLevel;
    private int projectsCompleted;
    
    public Developer(String employeeId, String name, double baseSalary, 
                    String[] programmingLanguages, String experienceLevel) {
        super(employeeId, name, baseSalary, "Development");
        this.programmingLanguages = programmingLanguages;
        this.experienceLevel = experienceLevel;
        this.projectsCompleted = 0;
        System.out.println("Developer profile created");
    }
    
    @Override
    public double calculateSalary() {
        double experienceBonus = 0;
        switch (experienceLevel.toLowerCase()) {
            case "senior": experienceBonus = 20000; break;
            case "mid": experienceBonus = 10000; break;
            case "junior": experienceBonus = 5000; break;
        }
        return baseSalary + experienceBonus + (projectsCompleted * 1000);
    }
    
    @Override
    public String getJobDescription() {
        return "Software Developer";
    }
    
    @Override
    public void performWork() {
        System.out.println("Developer is coding and debugging");
    }
    
    @Override
    public void attendMeeting() {
        System.out.println("Developer in technical meeting");
    }
    
    public void writeCode() {
        System.out.println("Writing code in " + String.join(", ", programmingLanguages));
    }
    
    public void reviewCode() {
        System.out.println("Reviewing team's code");
    }
    
    public void deployApplication() {
        System.out.println("Deploying application to production");
        projectsCompleted++;
    }
}

class Manager extends Employee {
    private int teamSize;
    private String managementLevel;
    private double budgetResponsibility;
    
    public Manager(String employeeId, String name, double baseSalary,
                  int teamSize, String managementLevel, double budgetResponsibility) {
        super(employeeId, name, baseSalary, "Management");
        this.teamSize = teamSize;
        this.managementLevel = managementLevel;
        this.budgetResponsibility = budgetResponsibility;
        System.out.println("Manager profile created");
    }
    
    @Override
    public double calculateSalary() {
        double teamBonus = teamSize * 1000;
        double levelBonus = 0;
        switch (managementLevel.toLowerCase()) {
            case "director": levelBonus = 30000; break;
            case "manager": levelBonus = 20000; break;
            case "team lead": levelBonus = 10000; break;
        }
        return baseSalary + teamBonus + levelBonus;
    }
    
    @Override
    public String getJobDescription() {
        return "Team Manager";
    }
    
    @Override
    public void performWork() {
        System.out.println("Manager is coordinating team activities");
    }
    
    @Override
    public void attendMeeting() {
        System.out.println("Manager leading strategic meeting");
    }
    
    public void conductPerformanceReview() {
        System.out.println("Conducting team performance review");
    }
    
    public void assignTasks() {
        System.out.println("Assigning tasks to team members");
    }
    
    public void manageBudget() {
        System.out.println("Managing department budget of $" + budgetResponsibility);
    }
}

class Intern extends Employee {
    private String university;
    private int internshipDuration;
    private String mentor;
    private boolean isFullTime;
    
    public Intern(String employeeId, String name, String university,
                 int internshipDuration, String mentor, boolean isFullTime) {
        super(employeeId, name, 2000, "Internship"); // Base stipend of $2000
        this.university = university;
        this.internshipDuration = internshipDuration;
        this.mentor = mentor;
        this.isFullTime = isFullTime;
        System.out.println("Intern onboarded");
    }
    
    @Override
    public double calculateSalary() {
        return isFullTime ? baseSalary : baseSalary * 0.5;
    }
    
    @Override
    public String getJobDescription() {
        return "Intern";
    }
    
    @Override
    public void performWork() {
        System.out.println("Intern is learning and assisting");
    }
    
    public void attendTraining() {
        System.out.println("Intern attending training session");
    }
    
    public void submitReport() {
        System.out.println("Submitting weekly progress report");
    }
    
    public void seekMentorship() {
        System.out.println("Getting guidance from mentor " + mentor);
    }
}

public class EmployeeHierarchy {
    public static void main(String[] args) {
        // Create array of Employee references
        Employee[] employees = new Employee[4];
        
        // Initialize with different employee types
        employees[0] = new Developer("DEV001", "John Doe", 60000,
                                   new String[]{"Java", "Python"}, "Senior");
        employees[1] = new Manager("MGR001", "Jane Smith", 80000,
                                 10, "Manager", 500000);
        employees[2] = new Intern("INT001", "Bob Wilson", "Tech University",
                                12, "DEV001", true);
        employees[3] = new Employee("EMP001", "Alice Brown", 45000, "HR");
        
        // Demonstrate polymorphic method calls
        System.out.println("\nPolymorphic method calls:");
        for (Employee emp : employees) {
            emp.performWork();
            emp.attendMeeting();
            System.out.println("Salary: $" + emp.calculateSalary());
        }
        
        // Demonstrate instanceof and type checking
        System.out.println("\nType checking:");
        for (Employee emp : employees) {
            if (emp instanceof Developer) {
                Developer dev = (Developer) emp;
                dev.writeCode();
            } else if (emp instanceof Manager) {
                Manager mgr = (Manager) emp;
                mgr.assignTasks();
            } else if (emp instanceof Intern) {
                Intern intern = (Intern) emp;
                intern.seekMentorship();
            }
        }
        
        // Test final method inheritance
        System.out.println("\nTesting final methods:");
        for (Employee emp : employees) {
            emp.printEmployeeDetails();
        }
        
        // Create EmployeeManager utility and demonstrate functionality
        EmployeeManager empManager = new EmployeeManager();
        System.out.println("\nEmployee Manager Reports:");
        empManager.calculateTotalPayroll(employees);
        empManager.printJobDescriptions(employees);
    }
}

class EmployeeManager {
    public void calculateTotalPayroll(Employee[] employees) {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        System.out.println("Total payroll: $" + total);
    }
    
    public void printJobDescriptions(Employee[] employees) {
        System.out.println("Job Descriptions:");
        for (Employee emp : employees) {
            System.out.println(emp.getEmployeeId() + ": " + emp.getJobDescription());
        }
    }
}
