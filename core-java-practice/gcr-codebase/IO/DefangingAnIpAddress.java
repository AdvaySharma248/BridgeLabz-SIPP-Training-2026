import java.util.Scanner;

public class DefangingAnIpAddress {

    public static String defangIPaddr(String address) {
        String result = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                result = result + "[.]";
            } else {
                result = result + address.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the IP address: ");
        String address = scanner.nextLine();

        String defanged = defangIPaddr(address);
        System.out.println("Defanged IP address: " + defanged);

        scanner.close();
    }
}
