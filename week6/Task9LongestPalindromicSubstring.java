import java.util.Scanner;

public class Task9LongestPalindromicSubstring {
    private static int[] expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return new int[]{left + 1, right - left - 1};
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expand(s, i, i);
            int[] even = expand(s, i, i + 1);

            if (odd[1] > maxLen) {
                start = odd[0];
                maxLen = odd[1];
            }
            if (even[1] > maxLen) {
                start = even[0];
                maxLen = even[1];
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.hasNextLine() ? scanner.nextLine() : "";
        if (s.isEmpty() && scanner.hasNextLine()) {
            s = scanner.nextLine();
        }

        System.out.println(longestPalindrome(s));
    }
}
