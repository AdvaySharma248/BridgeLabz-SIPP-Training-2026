public class RandomNumberStatistics {

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = (double) sum / numbers.length;
        double[] result = {average, min, max};
        return result;
    }

    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);

        System.out.print("The generated 4-digit random numbers are: ");
        for (int i = 0; i < randomNumbers.length; i++) {
            if (i < randomNumbers.length - 1) {
                System.out.print(randomNumbers[i] + ", ");
            } else {
                System.out.println(randomNumbers[i]);
            }
        }

        double[] stats = findAverageMinMax(randomNumbers);

        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + (int) stats[1]);
        System.out.println("Maximum: " + (int) stats[2]);
    }
}
