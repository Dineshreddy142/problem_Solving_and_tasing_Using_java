import java.util.Scanner;

public class Task3TheMaximumSubarray {
    private static int maxSubarraySum(int[] arr) {
        int best = arr[0];
        int current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            best = Math.max(best, current);
        }

        return best;
    }

    private static int maxSubsequenceSum(int[] arr) {
        int sumPositives = 0;
        int maxValue = arr[0];

        for (int value : arr) {
            if (value > 0) {
                sumPositives += value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return sumPositives > 0 ? sumPositives : maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int t = scanner.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int subarray = maxSubarraySum(arr);
            int subsequence = maxSubsequenceSum(arr);
            System.out.println(subarray + " " + subsequence);
        }
    }
}
