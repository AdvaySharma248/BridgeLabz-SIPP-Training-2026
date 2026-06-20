import java.util.Scanner;

public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter jewels string: ");
        String jewels = scanner.nextLine();

        System.out.print("Enter stones string: ");
        String stones = scanner.nextLine();

        int count = numJewelsInStones(jewels, stones);
        System.out.println("Number of jewels in stones: " + count);

        scanner.close();
    }
}
