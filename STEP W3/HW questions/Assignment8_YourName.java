/**
 * Assignment 8: Hospital Patient Management System
 * Author: YourName
 * Date: 2025-09-01
 *
 * Simple hospital management system demonstrating advanced object relationships and data management.
 */
class Patient {
    private String[] medicalHistory;
    private String[] currentTreatments;
    private int historyCount = 0;
    private int treatmentCount = 0;
    public Patient(int maxHistory, int maxTreatments) {
        this.medicalHistory = new String[maxHistory];
        this.currentTreatments = new String[maxTreatments];
    }

    public void addTreatment(String treatment) {
        if (treatmentCount < currentTreatments.length) currentTreatments[treatmentCount++] = treatment;
    }
    public void addHistory(String history) {
        if (historyCount < medicalHistory.length) medicalHistory[historyCount++] = history;
    }
}

class Doctor {
    private double consultationFee;
    public double getConsultationFee() { return consultationFee; }
    public Doctor(double fee) {
        this.consultationFee = fee;
    }
}

class Appointment {
    private static int totalAppointments = 0;
    private static String hospitalName = "Default Hospital";
    private static double totalRevenue = 0.0;

    public Appointment(Doctor doctor) {
        totalAppointments++;
        totalRevenue += doctor.getConsultationFee();
    }

    public void cancelAppointment(Doctor doctor) {
        totalRevenue -= doctor.getConsultationFee();
        System.out.println("Appointment cancelled");
    }

    public static String getHospitalName() { return hospitalName; }
    public static void setHospitalName(String name) { hospitalName = name; }
    public static int getTotalAppointments() { return totalAppointments; }
    public static double getTotalRevenue() { return totalRevenue; }
}

public class Assignment8_YourName {
    public static void main(String[] args) {
        Appointment.setHospitalName("Care Hospital");

    Doctor d1 = new Doctor(500);
    Doctor d2 = new Doctor(600);

    Patient p1 = new Patient(5, 3);
    Patient p2 = new Patient(5, 3);

    Appointment a1 = new Appointment(d1);
    Appointment a2 = new Appointment(d2);

        System.out.println("Total Appointments: " + Appointment.getTotalAppointments());
        System.out.println("Hospital Revenue: " + Appointment.getTotalRevenue());
        System.out.println("Hospital Name: " + Appointment.getHospitalName());

    a1.cancelAppointment(d1);
        System.out.println("Hospital Revenue after cancellation: " + Appointment.getTotalRevenue());
    }
}
