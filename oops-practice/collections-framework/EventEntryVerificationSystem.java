import java.util.HashSet;
import java.util.Set;

public class EventEntryVerificationSystem {
    private Set<String> participants;

    public EventEntryVerificationSystem() {
        participants = new HashSet<>();
    }

    public void registerParticipant(String email) {
        if (participants.add(email)) {
            System.out.println("Participant " + email + " registered successfully!");
        } else {
            System.out.println("Participant " + email + " is already registered!");
        }
    }

    public void displayParticipants() {
        System.out.println("Registered participants:");
        for (String email : participants) {
            System.out.println("- " + email);
        }
        System.out.println("Total attendees: " + participants.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem eventSystem = new EventEntryVerificationSystem();
        eventSystem.registerParticipant("alice@example.com");
        eventSystem.registerParticipant("bob@example.com");
        eventSystem.registerParticipant("alice@example.com");
        eventSystem.registerParticipant("charlie@example.com");
        eventSystem.displayParticipants();
    }
}
