// PROBLEM 4: Hospital Management System - Upcasting

class MedicalStaff {
    protected String name;
    protected String employeeId;
    protected String shift;

    public MedicalStaff(String name, String employeeId, String shift) {
        this.name = name;
        this.employeeId = employeeId;
        this.shift = shift;
    }

    public void scheduleShift() {
        System.out.println("Scheduling shift for " + name + " (ID: " + employeeId + ")");
        System.out.println("Assigned shift: " + shift);
    }

    public void accessIdCard() {
        System.out.println("ID Card Access: " + name + " - " + employeeId);
        System.out.println("Access granted to authorized areas");
    }

    public void processPayroll() {
        System.out.println("Processing payroll for: " + name);
        System.out.println("Employee ID: " + employeeId);
    }

    public void displayInfo() {
        System.out.println("\nStaff: " + name);
        System.out.println("ID: " + employeeId);
    }
}

class Doctor extends MedicalStaff {
    private String specialization;

    public Doctor(String name, String employeeId, String shift, String specialization) {
        super(name, employeeId, shift);
        this.specialization = specialization;
    }

    public void diagnosePatient() {
        System.out.println("Dr. " + name + " diagnosing patient");
    }

    public void prescribeMedicine() {
        System.out.println("Dr. " + name + " prescribing medication");
    }

    public void performSurgery() {
        System.out.println("Dr. " + name + " performing surgery - " + specialization);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Doctor");
        System.out.println("Specialization: " + specialization);
    }
}

class Nurse extends MedicalStaff {
    private String department;

    public Nurse(String name, String employeeId, String shift, String department) {
        super(name, employeeId, shift);
        this.department = department;
    }

    public void administerMedicine() {
        System.out.println("Nurse " + name + " administering medication");
    }

    public void monitorPatient() {
        System.out.println("Nurse " + name + " monitoring patient vitals");
    }

    public void assistProcedure() {
        System.out.println("Nurse " + name + " assisting medical procedure");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Nurse");
        System.out.println("Department: " + department);
    }
}

class Technician extends MedicalStaff {
    private String equipmentType;

    public Technician(String name, String employeeId, String shift, String equipmentType) {
        super(name, employeeId, shift);
        this.equipmentType = equipmentType;
    }

    public void operateEquipment() {
        System.out.println("Technician " + name + " operating " + equipmentType);
    }

    public void runTests() {
        System.out.println("Technician " + name + " running diagnostic tests");
    }

    public void maintainInstruments() {
        System.out.println("Technician " + name + " maintaining instruments");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Technician");
        System.out.println("Equipment: " + equipmentType);
    }
}

class Administrator extends MedicalStaff {
    private String office;

    public Administrator(String name, String employeeId, String shift, String office) {
        super(name, employeeId, shift);
        this.office = office;
    }

    public void scheduleAppointment() {
        System.out.println("Administrator " + name + " scheduling appointments");
    }

    public void manageRecords() {
        System.out.println("Administrator " + name + " managing patient records");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Administrator");
        System.out.println("Office: " + office);
    }
}

public class Problem4 {
    public static void main(String[] args) {
        // Upcasting - treating specific staff as general MedicalStaff
        MedicalStaff staff1 = new Doctor("Sarah Johnson", "DOC001", "Morning", "Cardiology");
        MedicalStaff staff2 = new Nurse("Emily Davis", "NUR001", "Evening", "ICU");
        MedicalStaff staff3 = new Technician("Mike Wilson", "TECH001", "Night", "X-Ray");
        MedicalStaff staff4 = new Administrator("Lisa Brown", "ADM001", "Morning", "Reception");

        System.out.println("===== HOSPITAL INSTITUTIONAL OPERATIONS =====");
        
        // Common operations for all staff (institutional level)
        MedicalStaff[] allStaff = {staff1, staff2, staff3, staff4};
        
        for (MedicalStaff staff : allStaff) {
            staff.displayInfo();
            staff.scheduleShift();
            staff.accessIdCard();
            staff.processPayroll();
            System.out.println("---");
        }
    }
}
