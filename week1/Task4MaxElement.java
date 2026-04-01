public class Task4MaxElement {
    public static void main(String[] args) {
        int[] arr = {45, 12, 78, 34, 89, 66};
        System.out.println("Maximum element = " + findMax(arr));
    }

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
}