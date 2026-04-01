import java.util.Scanner;

public class Task4MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0;
        int maxSum = nums[0];
        int curMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);

            total += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, total - minSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(maxSubarraySumCircular(nums));
    }
}
