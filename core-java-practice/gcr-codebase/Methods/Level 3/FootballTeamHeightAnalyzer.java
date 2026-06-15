public class FootballTeamHeightAnalyzer {

    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }
        return heights;
    }

    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum = sum + height;
        }
        return sum;
    }

    public static double findMeanHeight(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    public static int findShortestHeight(int[] heights) {
        int shortest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < shortest) {
                shortest = heights[i];
            }
        }
        return shortest;
    }

    public static int findTallestHeight(int[] heights) {
        int tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        int numberOfPlayers = 11;
        int[] heights = generateRandomHeights(numberOfPlayers);

        System.out.print("Heights of 11 players (in cm): ");
        for (int i = 0; i < heights.length; i++) {
            if (i < heights.length - 1) {
                System.out.print(heights[i] + ", ");
            } else {
                System.out.println(heights[i]);
            }
        }

        double meanHeight = findMeanHeight(heights);
        int shortest = findShortestHeight(heights);
        int tallest = findTallestHeight(heights);

        System.out.println("The mean height of the players is " + String.format("%.2f", meanHeight) + " cm");
        System.out.println("The shortest height of the players is " + shortest + " cm");
        System.out.println("The tallest height of the players is " + tallest + " cm");
    }
}
