import java.util.Scanner;

class Patient {
    static String hospitalName = "City General Hospital";
    static int totalPatients = 0;

    String name;
    int age;
    String ailment;
    final int patientID;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter patient name: ");
        String n = sc.nextLine();
        System.out.print("Enter age: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter ailment: ");
        String al = sc.nextLine();
        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();

        Patient p1 = new Patient(n, a, al, id);

        if (p1 instanceof Patient) {
            p1.displayDetails();
        }

        sc.nextLine();
        System.out.print("Enter patient name: ");
        String n2 = sc.nextLine();
        System.out.print("Enter age: ");
        int a2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter ailment: ");
        String al2 = sc.nextLine();
        System.out.print("Enter patient ID: ");
        int id2 = sc.nextInt();

        Patient p2 = new Patient(n2, a2, al2, id2);

        if (p2 instanceof Patient) {
            p2.displayDetails();
        }

        Patient.getTotalPatients();

        sc.close();
    }
}
