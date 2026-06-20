import java.util.Scanner;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        int[] frequency = new int[256];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i)]++;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int maxFreq = 0;
            char maxChar = 0;
            for (int j = 0; j < 256; j++) {
                if (frequency[j] > maxFreq) {
                    maxFreq = frequency[j];
                    maxChar = (char) j;
                }
            }
            if (maxFreq > 0) {
                for (int k = 0; k < maxFreq; k++) {
                    result = result + maxChar;
                }
                frequency[maxChar] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        String sorted = frequencySort(s);
        System.out.println("Sorted by frequency: " + sorted);

        scanner.close();
    }
}
