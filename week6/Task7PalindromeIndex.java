import java.util.Scanner;

public class Task7PalindromeIndex {
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            if (isPalindrome(s, left + 1, right)) {
                return left;
            }
            if (isPalindrome(s, left, right - 1)) {
                return right;
            }
            return -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            System.out.println(palindromeIndex(s));
        }
    }
}
