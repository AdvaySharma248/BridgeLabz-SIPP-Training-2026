public class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public void displayInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Platform: " + platform);
        System.out.println("Fee: " + fee);
    }
}
