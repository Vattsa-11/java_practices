public class RandomStats {
    public int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) numbers[i] = (int) (Math.random() * 9000) + 1000;
        return numbers;
    }
    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }
    public static void main(String[] args) {
        RandomStats stats = new RandomStats();
        int[] randomNumbers = stats.generate4DigitRandomArray(5);
        System.out.println("Generated 4-digit random numbers:");
        for (int num : randomNumbers) System.out.println(num);
        double[] results = stats.findAverageMinMax(randomNumbers);
        System.out.printf("\nAverage: %.2f\n", results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
}

