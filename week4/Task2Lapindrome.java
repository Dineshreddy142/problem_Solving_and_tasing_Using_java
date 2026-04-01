import java.util.Arrays;
import java.util.Scanner;

public class Task2Lapindrome {
    private static boolean isLapindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        char[] left = s.substring(0, mid).toCharArray();
        char[] right = s.substring((n % 2 == 0) ? mid : mid + 1).toCharArray();

        Arrays.sort(left);
        Arrays.sort(right);

        return Arrays.equals(left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(isLapindrome(s) ? "YES" : "NO");
        }
    }
}
