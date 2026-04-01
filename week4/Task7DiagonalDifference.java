import java.util.Scanner;

public class Task7DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        long primary = 0;
        long secondary = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                if (i == j) {
                    primary += value;
                }
                if (i + j == n - 1) {
                    secondary += value;
                }
            }
        }

        System.out.println(Math.abs(primary - secondary));
    }
}
