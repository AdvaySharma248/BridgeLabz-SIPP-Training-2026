import java.util.Scanner;

public class StudentScorecardGenerator {

    public static int[][] generatePCMScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }
        return scores;
    }

    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / 3;
            double percentage = (double) total / 300 * 100;
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("\nStudent Scorecard");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Student\t\tPhysics\t\tChemistry\tMath\t\tTotal\t\tAverage\t\tPercentage");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.println("Student " + (i + 1)
                    + "\t" + scores[i][0]
                    + "\t\t" + scores[i][1]
                    + "\t\t" + scores[i][2]
                    + "\t\t" + (int) results[i][0]
                    + "\t\t" + results[i][1]
                    + "\t\t" + results[i][2] + "%");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[][] scores = generatePCMScores(numberOfStudents);
        double[][] results = calculateTotalAveragePercentage(scores);

        displayScorecard(scores, results);

        scanner.close();
    }
}
