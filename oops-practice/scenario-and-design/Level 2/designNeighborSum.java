import java.util.Scanner;
import java.util.HashMap;

class NeighborSum {
    int[][] grid;
    int rows;
    int cols;
    HashMap<Integer, int[]> posMap;

    NeighborSum(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        posMap = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                posMap.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    int getNeighborSum(int value) {
        int[] pos = posMap.get(value);
        if (pos == null) return 0;
        int r = pos[0];
        int c = pos[1];
        int sum = 0;

        if (r > 0) sum += grid[r - 1][c];
        if (r < rows - 1) sum += grid[r + 1][c];
        if (c > 0) sum += grid[r][c - 1];
        if (c < cols - 1) sum += grid[r][c + 1];

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        NeighborSum ns = new NeighborSum(grid);

        System.out.println("Neighbor sum of 5: " + ns.getNeighborSum(5));
        System.out.println("Neighbor sum of 1: " + ns.getNeighborSum(1));
        System.out.println("Neighbor sum of 9: " + ns.getNeighborSum(9));
        System.out.println("Neighbor sum of 4: " + ns.getNeighborSum(4));

        sc.close();
    }
}
