public class Task3BinarySearch {
    public static void main(String[] args) {
        int[] sortedArr = {3, 8, 12, 17, 25, 31, 44};
        int target = 25;

        int index = binarySearch(sortedArr, target);
        System.out.println("Element " + target + " found at index: " + index);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}