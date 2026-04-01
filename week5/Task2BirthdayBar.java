import java.util.Scanner;

public class Task2BirthdayBar {
    public static int birthday(int[] s, int d, int m) {
        if (m > s.length) {
            return 0;
        }

        int count = 0;
        int windowSum = 0;

        for (int i = 0; i < m; i++) {
            windowSum += s[i];
        }
        if (windowSum == d) {
            count++;
        }

        for (int i = m; i < s.length; i++) {
            windowSum += s[i] - s[i - m];
            if (windowSum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        int d = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(birthday(s, d, m));
    }
}
