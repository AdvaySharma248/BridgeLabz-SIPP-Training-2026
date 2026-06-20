import java.util.Scanner;

public class FindIndexOfFirstOccurrence {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the haystack string: ");
        String haystack = scanner.nextLine();

        System.out.print("Enter the needle string: ");
        String needle = scanner.nextLine();

        int index = strStr(haystack, needle);

        if (index != -1) {
            System.out.println("First occurrence of \"" + needle + "\" found at index " + index);
        } else {
            System.out.println("Needle not found in haystack");
        }

        scanner.close();
    }
}
