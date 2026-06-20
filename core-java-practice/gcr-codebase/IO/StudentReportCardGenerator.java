import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentReportCardGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile = "students.txt";
        String outputFile = "reportcard.txt";

        System.out.print("How many students do you want to enter: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter(inputFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter student " + (i + 1) + " name: ");
                String name = scanner.nextLine();

                System.out.print("Enter marks in Subject 1: ");
                int mark1 = scanner.nextInt();

                System.out.print("Enter marks in Subject 2: ");
                int mark2 = scanner.nextInt();

                System.out.print("Enter marks in Subject 3: ");
                int mark3 = scanner.nextInt();
                scanner.nextLine();

                printWriter.println(name + "," + mark1 + "," + mark2 + "," + mark3);
            }

            printWriter.close();
            System.out.println("Student data saved to " + inputFile);

        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try {
            File file = new File(inputFile);
            Scanner fileScanner = new Scanner(file);

            FileWriter fileWriter = new FileWriter(outputFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("========================================");
            printWriter.println("       STUDENT REPORT CARD");
            printWriter.println("========================================");

            int studentCount = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length < 4) {
                    continue;
                }

                studentCount++;
                String name = parts[0].trim();
                int mark1 = Integer.parseInt(parts[1].trim());
                int mark2 = Integer.parseInt(parts[2].trim());
                int mark3 = Integer.parseInt(parts[3].trim());

                int total = mark1 + mark2 + mark3;
                double average = (double) total / 3;

                String grade;
                if (average >= 90) {
                    grade = "A";
                } else if (average >= 75) {
                    grade = "B";
                } else if (average >= 60) {
                    grade = "C";
                } else if (average >= 40) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                printWriter.println("Student " + studentCount + ": " + name);
                printWriter.println("  Subject 1: " + mark1);
                printWriter.println("  Subject 2: " + mark2);
                printWriter.println("  Subject 3: " + mark3);
                printWriter.println("  Total: " + total);
                printWriter.println("  Average: " + String.format("%.2f", average));
                printWriter.println("  Grade: " + grade);
                printWriter.println("----------------------------------------");
            }

            printWriter.println("========================================");
            printWriter.close();
            fileScanner.close();

            System.out.println("Report card generated in " + outputFile);
            System.out.println("Total students processed: " + studentCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
            System.out.println("Please add student data first before generating report card");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
