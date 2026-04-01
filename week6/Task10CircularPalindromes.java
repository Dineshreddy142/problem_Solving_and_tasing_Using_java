import java.util.Scanner;

public class Task10CircularPalindromes {
    private static int longestPalindromeLength(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        StringBuilder transformed = new StringBuilder();
        transformed.append('^');
        for (int i = 0; i < s.length(); i++) {
            transformed.append('#').append(s.charAt(i));
        }
        transformed.append("#$");

        int n = transformed.length();
        int[] p = new int[n];
        int center = 0;
        int right = 0;
        int best = 1;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (transformed.charAt(i + 1 + p[i]) == transformed.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            best = Math.max(best, p[i]);
        }

        return best;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        String s = scanner.next();

        for (int shift = 0; shift < n; shift++) {
            String rotated = s.substring(shift) + s.substring(0, shift);
            System.out.println(longestPalindromeLength(rotated));
        }
    }
}
