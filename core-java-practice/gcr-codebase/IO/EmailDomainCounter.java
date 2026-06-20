import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmailDomainCounter {

    public static String[] extractDomains(String[] emails) {
        String[] domains = new String[emails.length];
        for (int i = 0; i < emails.length; i++) {
            int atIndex = emails[i].indexOf("@");
            if (atIndex != -1) {
                domains[i] = emails[i].substring(atIndex + 1);
            } else {
                domains[i] = "unknown";
            }
        }
        return domains;
    }

    public static void countDomains(String[] domains) {
        int uniqueCount = 0;
        String[] uniqueDomains = new String[domains.length];
        int[] counts = new int[domains.length];

        for (int i = 0; i < domains.length; i++) {
            boolean found = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueDomains[j].equals(domains[i])) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                uniqueDomains[uniqueCount] = domains[i];
                counts[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        System.out.println("\nDomain Count:");
        System.out.println("----------------------------------------");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(uniqueDomains[i] + ": " + counts[i] + " user(s)");
        }
    }

    public static void main(String[] args) {
        String fileName = "emails.txt";

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            int lineCount = 0;
            while (fileScanner.hasNextLine()) {
                lineCount++;
                fileScanner.nextLine();
            }
            fileScanner.close();

            String[] emails = new String[lineCount];
            fileScanner = new Scanner(file);
            int index = 0;
            while (fileScanner.hasNextLine()) {
                emails[index] = fileScanner.nextLine().trim();
                index++;
            }
            fileScanner.close();

            System.out.println("Emails read from file:");
            for (int i = 0; i < emails.length; i++) {
                System.out.println(emails[i]);
            }

            String[] domains = extractDomains(emails);
            countDomains(domains);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.out.println("Please create the file with email addresses first");
        }
    }
}
