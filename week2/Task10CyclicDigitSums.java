import java.util.Scanner;

public class Task10CyclicDigitSums {
    private static int digitSum(int value) {
        int n = Math.abs(value);
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static int sumOfSumsInCycle(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int next = arr[(i + 1) % arr.length];
            total += digitSum(arr[i] + next);
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(sumOfSumsInCycle(arr));
    }
}
