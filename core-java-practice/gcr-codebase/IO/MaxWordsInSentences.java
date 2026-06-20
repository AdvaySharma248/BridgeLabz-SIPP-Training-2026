import java.util.Scanner;

public class MaxWordsInSentences {

    public static int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for (int i = 0; i < sentences.length; i++) {
            int wordCount = 1;
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ') {
                    wordCount++;
                }
            }
            if (wordCount > maxWords) {
                maxWords = wordCount;
            }
        }
        return maxWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many sentences do you want to enter: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] sentences = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter sentence " + (i + 1) + ": ");
            sentences[i] = scanner.nextLine();
        }

        int maxWords = mostWordsFound(sentences);
        System.out.println("Maximum number of words in a sentence: " + maxWords);

        scanner.close();
    }
}
