import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartClassroomAttendanceTracker {
    private Map<String, List<String>> attendanceMap;

    public SmartClassroomAttendanceTracker() {
        attendanceMap = new HashMap<>();
    }

    public void markAttendance(String subject, String student) {
        if (!attendanceMap.containsKey(subject)) {
            attendanceMap.put(subject, new ArrayList<>());
        }
        List<String> students = attendanceMap.get(subject);
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Attendance marked for " + student + " in " + subject);
        } else {
            System.out.println(student + " is already marked present in " + subject);
        }
    }

    public void displayAttendance() {
        for (Map.Entry<String, List<String>> entry : attendanceMap.entrySet()) {
            String subject = entry.getKey();
            List<String> students = entry.getValue();
            System.out.println("\nSubject: " + subject);
            System.out.println("Students present:");
            for (String student : students) {
                System.out.println("- " + student);
            }
            System.out.println("Total students present: " + students.size());
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();
        tracker.markAttendance("Java", "Alice");
        tracker.markAttendance("Java", "Bob");
        tracker.markAttendance("Java", "Alice");
        tracker.markAttendance("Python", "Charlie");
        tracker.markAttendance("Python", "Bob");
        tracker.displayAttendance();
    }
}
