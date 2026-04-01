public class Task2AccessElement {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int index = 2;

        System.out.println("Element at index " + index + " = " + getElementAtIndex(arr, index));
    }

    public static int getElementAtIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        return arr[index];
    }
}