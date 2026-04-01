import java.util.Scanner;

public class Task6MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int insert = 0;

        for (int value : nums) {
            if (value != 0) {
                nums[insert++] = value;
            }
        }

        while (insert < nums.length) {
            nums[insert++] = 0;
        }
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

        moveZeroes(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(nums[i]);
        }

        System.out.println(sb);
    }
}
