package polymorphism;

class LibraryMember {
    String memberName;
    String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public void calculateFine(int overdueDays) {
        System.out.println("Calculating fine for " + memberName);
    }

    public void displayDetails() {
        System.out.println("ID: " + memberId + " | Name: " + memberName);
    }
}

class StudentMember extends LibraryMember {
    public StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public void calculateFine(int overdueDays) {
        double fine = overdueDays * 2.0; // Student fine is $2 per day
        System.out.println("Student " + memberName + " fine for " + overdueDays + " days: $" + fine);
    }
}

class FacultyMember extends LibraryMember {
    public FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public void calculateFine(int overdueDays) {
        double fine = overdueDays * 5.0; // Faculty fine is $5 per day
        System.out.println("Faculty " + memberName + " fine for " + overdueDays + " days: $" + fine);
    }
}

class GuestMember extends LibraryMember {
    public GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public void calculateFine(int overdueDays) {
        double fine = overdueDays * 10.0; // Guest fine is $10 per day
        System.out.println("Guest " + memberName + " fine for " + overdueDays + " days: $" + fine);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Requirement 1: Store all members in a LibraryMember[] array
        LibraryMember[] members = new LibraryMember[3];
        members[0] = new StudentMember("John Doe", "S101");
        members[1] = new FacultyMember("Dr. Smith", "F202");
        members[2] = new GuestMember("Alice Brown", "G303");

        // Requirement 2: Create a method to print member details
        System.out.println("--- Library Member Details ---");
        for (LibraryMember m : members) {
            m.displayDetails();
        }

        // Requirement 3: Use dynamic method dispatch to calculate fines
        System.out.println("\n--- Calculating Fines (Overdue: 5 days) ---");
        for (LibraryMember m : members) {
            m.calculateFine(5);
        }

        // Requirement 4: Find and display the member whose ID matches a given string
        String searchId = "F202";
        System.out.println("\n--- Searching for Member ID: " + searchId + " ---");
        boolean found = false;
        for (LibraryMember m : members) {
            if (m.memberId.equals(searchId)) {
                System.out.print("Found: ");
                m.displayDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Member not found.");
        }
    }
}
