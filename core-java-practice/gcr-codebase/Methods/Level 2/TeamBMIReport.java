import java.util.Scanner;

public class TeamBMIReport {

    public static double[][] calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100;
            data[i][2] = weight / (heightInMeters * heightInMeters);
        }
        return data;
    }

    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 16) {
                status[i] = "Severe Thinness";
            } else if (bmi >= 16 && bmi < 17) {
                status[i] = "Moderate Thinness";
            } else if (bmi >= 17 && bmi < 18.5) {
                status[i] = "Mild Thinness";
            } else if (bmi >= 18.5 && bmi < 25) {
                status[i] = "Normal";
            } else if (bmi >= 25 && bmi < 30) {
                status[i] = "Overweight";
            } else if (bmi >= 30 && bmi < 35) {
                status[i] = "Obese Class I";
            } else if (bmi >= 35 && bmi < 40) {
                status[i] = "Obese Class II";
            } else {
                status[i] = "Obese Class III";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the weight (in kg) of person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter the height (in cm) of person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }

        data = calculateBMI(data);
        String[] status = determineBMIStatus(data);

        System.out.println("\nTeam BMI Report");
        System.out.println("----------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1)
                    + " | Weight: " + data[i][0] + " kg"
                    + " | Height: " + data[i][1] + " cm"
                    + " | BMI: " + String.format("%.2f", data[i][2])
                    + " | Status: " + status[i]);
        }

        scanner.close();
    }
}
