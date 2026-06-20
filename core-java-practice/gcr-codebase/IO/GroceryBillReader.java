import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GroceryBillReader {

    public static void main(String[] args) {
        String fileName = "bill.txt";
        int lineCount = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Contents of " + fileName + ":");
            System.out.println("----------------------------------------");

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                lineCount++;
                line = bufferedReader.readLine();
            }

            System.out.println("----------------------------------------");
            System.out.println("Total number of lines: " + lineCount);

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.out.println("Please create the file first");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
