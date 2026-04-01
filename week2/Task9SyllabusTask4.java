import java.util.Scanner;

public class Task9SyllabusTask4 {
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        return max;
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

        System.out.println(findMax(arr));
    }
}
