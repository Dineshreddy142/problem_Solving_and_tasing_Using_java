public class Task9PalindromeNumber {
    public static void main(String[] args) {
        int number = 12321;
        System.out.println("Is palindrome? " + isPalindromeNumber(number));
    }

    public static boolean isPalindromeNumber(int number) {
        if (number < 0) {
            return false;
        }

        int original = number;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }
}