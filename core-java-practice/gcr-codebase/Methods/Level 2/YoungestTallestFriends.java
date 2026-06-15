import java.util.Scanner;

public class YoungestTallestFriends {

    public static int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < youngest) {
                youngest = ages[i];
            }
        }
        return youngest;
    }

    public static double findTallest(double[] heights) {
        double tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter the height of " + names[i] + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        int youngestAge = findYoungest(ages);
        double tallestHeight = findTallest(heights);

        String youngestName = "";
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] == youngestAge) {
                youngestName = names[i];
                break;
            }
        }

        String tallestName = "";
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == tallestHeight) {
                tallestName = names[i];
                break;
            }
        }

        System.out.println("The youngest friend is " + youngestName + " with age " + youngestAge);
        System.out.println("The tallest friend is " + tallestName + " with height " + tallestHeight + " cm");

        scanner.close();
    }
}
