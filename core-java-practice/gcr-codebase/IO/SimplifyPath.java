import java.util.Scanner;
import java.util.ArrayList;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        ArrayList<String> stack = new ArrayList<>();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size() - 1);
                }
            } else {
                stack.add(part);
            }
        }

        String result = "";
        for (int i = 0; i < stack.size(); i++) {
            result = result + "/" + stack.get(i);
        }

        if (result.equals("")) {
            result = "/";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path: ");
        String path = scanner.nextLine();

        String simplifiedPath = simplifyPath(path);
        System.out.println("Simplified path: " + simplifiedPath);

        scanner.close();
    }
}
