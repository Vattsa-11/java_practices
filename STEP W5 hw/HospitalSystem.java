import java.time.LocalDate;
import java.util.*;

// Immutable Medical Record
final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies, 
                        String[] medicalHistory, LocalDate birthDate, String bloodType) {
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies.clone();
        this.medicalHistory = medicalHistory.clone();
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String[] getAllergies() { return allergies.clone(); }
    public String[] getMedicalHistory() { return medicalHistory.clone(); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        return Arrays.asList(allergies).contains(substance);
    }
}

// Patient class with privacy levels
class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    // Emergency admission constructor
    public Patient(String currentName) {
        this.patientId = "TEMP-" + UUID.randomUUID().toString().substring(0, 8);
        this.currentName = currentName;
        this.medicalRecord = new MedicalRecord(
            this.patientId,
            "PENDING",
            new String[]{},
            new String[]{"Emergency Admission"},
            LocalDate.now(),
            "UNKNOWN"
        );
    }

    // Standard admission constructor
    public Patient(String currentName, LocalDate birthDate, String bloodType, 
                  String[] allergies, String emergencyContact) {
        this.patientId = "P-" + UUID.randomUUID().toString().substring(0, 8);
        this.currentName = currentName;
        this.emergencyContact = emergencyContact;
        this.medicalRecord = new MedicalRecord(
            this.patientId,
            "DNA-" + UUID.randomUUID().toString().substring(0, 8),
            allergies,
            new String[]{"New Admission"},
            birthDate,
            bloodType
        );
    }

    // Package-private access for hospital staff
    String getBasicInfo() {
        return String.format("Patient: %s, ID: %s, Room: %d, Doctor: %s", 
                           currentName, patientId, roomNumber, attendingPhysician);
    }

    // Public access for general information
    public String getPublicInfo() {
        return String.format("Patient: %s, Room: %d", currentName, roomNumber);
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAttendingPhysician(String physician) {
        this.attendingPhysician = physician;
    }
}

// Medical staff classes
class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String licenseNumber, String specialty, Set<String> certifications) {
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
        this.certifications = new HashSet<>(certifications);
    }

    public String getLicenseNumber() { return licenseNumber; }
    public String getSpecialty() { return specialty; }
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String nurseId, String shift, List<String> qualifications) {
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualifications = new ArrayList<>(qualifications);
    }
}

// Hospital System with access control
public class HospitalSystem {
    private final Map<String, Patient> patientRegistry = new HashMap<>();
    private final Map<String, Doctor> doctorRegistry = new HashMap<>();
    private final Map<String, Nurse> nurseRegistry = new HashMap<>();

    public boolean admitPatient(Object patient, Object staff) {
        if (!(patient instanceof Patient)) return false;
        if (!(staff instanceof Doctor || staff instanceof Nurse)) return false;

        Patient p = (Patient) patient;
        patientRegistry.put(p.getPublicInfo(), p);
        return true;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        return staff instanceof Doctor || staff instanceof Nurse;
    }

    public static void main(String[] args) {
        HospitalSystem hospital = new HospitalSystem();

        // Emergency admission
        Patient emergency = new Patient("John Doe");
        emergency.setRoomNumber(101);

        // Standard admission
        Patient standard = new Patient("Jane Smith", 
            LocalDate.of(1990, 5, 15),
            "O+",
            new String[]{"Penicillin"},
            "123-456-7890"
        );
        standard.setRoomNumber(202);

        // Create medical staff
        Doctor doctor = new Doctor("L123", "Cardiology", 
            new HashSet<>(Arrays.asList("BLS", "ACLS")));
        Nurse nurse = new Nurse("N456", "Day", 
            Arrays.asList("RN", "Critical Care"));

        // Admit patients
        hospital.admitPatient(emergency, doctor);
        hospital.admitPatient(standard, nurse);

        // Test access levels
        System.out.println("\nEmergency Patient Public Info:");
        System.out.println(emergency.getPublicInfo());

        System.out.println("\nStandard Patient Basic Info (Staff Access):");
        System.out.println(standard.getBasicInfo());
    }
}
