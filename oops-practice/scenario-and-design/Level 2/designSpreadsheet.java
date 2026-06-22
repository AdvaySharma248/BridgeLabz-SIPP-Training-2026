import java.util.Scanner;

class Spreadsheet {
    int[][] grid;
    int rows;
    int cols;

    Spreadsheet(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new int[rows][cols];
    }

    void setCell(int row, int col, int value) {
        grid[row][col] = value;
    }

    int getCell(int row, int col) {
        return grid[row][col];
    }

    void setRow(int row, int[] values) {
        for (int i = 0; i < cols && i < values.length; i++) {
            grid[row][i] = values[i];
        }
    }

    int getRowSum(int row) {
        int sum = 0;
        for (int i = 0; i < cols; i++) {
            sum += grid[row][i];
        }
        return sum;
    }

    int getColSum(int col) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += grid[i][col];
        }
        return sum;
    }

    void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Spreadsheet sheet = new Spreadsheet(3, 3);

        sheet.setRow(0, new int[]{10, 20, 30});
        sheet.setRow(1, new int[]{40, 50, 60});
        sheet.setRow(2, new int[]{70, 80, 90});

        System.out.println("Spreadsheet:");
        sheet.display();

        System.out.println("Row 1 sum: " + sheet.getRowSum(1));
        System.out.println("Col 2 sum: " + sheet.getColSum(2));

        sheet.setCell(1, 1, 55);
        System.out.println("\nAfter update:");
        sheet.display();
        System.out.println("Cell (1,1): " + sheet.getCell(1, 1));

        sc.close();
    }
}
