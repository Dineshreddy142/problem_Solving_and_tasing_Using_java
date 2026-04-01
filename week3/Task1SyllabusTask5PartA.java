import java.util.Arrays;
import java.util.Scanner;

public class Task1SyllabusTask5PartA {
    public static int kthSmallest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            return -1;
        }

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy[k - 1];
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

        int k = scanner.nextInt();
        System.out.println(kthSmallest(arr, k));
    }
}
