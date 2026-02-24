// Hospital Patient Monitoring System

class Patient {

    // VARIABLES
    String name;
    int age;
    int bodyTemp;
    float oxygenLevel;

    // CONSTRUCTOR
    Patient(String name, int age, int bodyTemp, float oxygenLevel) {
        this.name = name;
        this.age = age;
        this.bodyTemp = bodyTemp;
        this.oxygenLevel = oxygenLevel;
    }

    // METHOD: Check Critical Condition
    boolean isCritical() {
        return (bodyTemp > 100 || oxygenLevel < 90);
    }

    // METHOD: Assign Ward (Returns Ward Name)
    String assignWard() {
        if (oxygenLevel < 90) {
            return "ICU Ward";
        } else if (oxygenLevel >= 90 && oxygenLevel <= 95) {
            return "Emergency Ward";
        } else {
            return "General Ward";
        }
    }

    // METHOD: Display Patient Details
    void display() {
        System.out.println("=================================");
        System.out.println("Patient Name      : " + name);
        System.out.println("Age               : " + age);
        System.out.println("Body Temperature  : " + bodyTemp + " °F");
        System.out.println("Oxygen Level      : " + oxygenLevel + " %");
        System.out.println("Assigned Ward     : " + assignWard());

        if (isCritical()) {
            System.out.println("Status            : CRITICAL");
        } else {
            System.out.println("Status            : Stable");
        }
        System.out.println("=================================\n");
    }

    // STATIC METHOD: Count Critical Patients
    static void countCriticalPatients(Patient[] patients) {
        int count = 0;

        for (Patient p : patients) {
            if (p.isCritical()) {
                count++;
            }
        }

        System.out.println("Total Critical Patients in Hospital: " + count);
    }
}

// MAIN CLASS
public class task03 {

    public static void main(String[] args) {

        System.out.println("===== HOSPITAL PATIENT MONITORING SYSTEM =====\n");

        Patient[] patients = new Patient[3];

        patients[0] = new Patient("Jon", 45, 103, 88);
        patients[1] = new Patient("Ali", 30, 98, 92);
        patients[2] = new Patient("Hania", 60, 101, 85);

        // Display all patients
        for (Patient patient : patients) {
            patient.display();
        }

        // Count Critical Patients
        Patient.countCriticalPatients(patients);
    }
}