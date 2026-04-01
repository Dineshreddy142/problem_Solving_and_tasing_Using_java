import java.util.Arrays;

public class Task5KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(k + "rd smallest element = " + kthSmallest(arr, k));
    }

    public static int kthSmallest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("k must be between 1 and " + arr.length);
        }

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy[k - 1];
    }
}