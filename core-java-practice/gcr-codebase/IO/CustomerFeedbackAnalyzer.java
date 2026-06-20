import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CustomerFeedbackAnalyzer {

    public static int countGoodFeedback(String[] feedbacks) {
        int count = 0;
        for (int i = 0; i < feedbacks.length; i++) {
            String lowerCaseFeedback = feedbacks[i].toLowerCase();
            if (lowerCaseFeedback.contains("good")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] feedbacks = new String[5];

        System.out.println("Enter 5 customer feedback messages:");
        for (int i = 0; i < feedbacks.length; i++) {
            System.out.print("Feedback " + (i + 1) + ": ");
            feedbacks[i] = reader.readLine();
        }

        int goodCount = countGoodFeedback(feedbacks);
        System.out.println("Good Feedback Count = " + goodCount);

        reader.close();
    }
}
