abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    int getPatientId() {
        return patientId;
    }

    void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    abstract double calculateBill();

    void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;

    double getRoomCharges() {
        return roomCharges;
    }

    void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    double getTreatmentCharges() {
        return treatmentCharges;
    }

    void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends Patient {
    private double consultationFees;
    private double treatmentCharges;

    double getConsultationFees() {
        return consultationFees;
    }

    void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    double getTreatmentCharges() {
        return treatmentCharges;
    }

    void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}

public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient();
        inPatient.setPatientId(101);
        inPatient.setName("David");
        inPatient.setAge(45);
        inPatient.setRoomCharges(5000);
        inPatient.setTreatmentCharges(3000);

        OutPatient outPatient = new OutPatient();
        outPatient.setPatientId(102);
        outPatient.setName("Emma");
        outPatient.setAge(30);
        outPatient.setConsultationFees(500);
        outPatient.setTreatmentCharges(2000);

        System.out.println("In-Patient Details:");
        inPatient.displayPatientDetails();
        System.out.println("Total Bill: " + inPatient.calculateBill());
        System.out.println();

        System.out.println("Out-Patient Details:");
        outPatient.displayPatientDetails();
        System.out.println("Total Bill: " + outPatient.calculateBill());
    }
}
