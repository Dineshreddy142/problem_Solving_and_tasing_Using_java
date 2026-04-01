import java.util.Scanner;

public class Task8HillPatternWeight {
    public static long hillWeight(int n) {
        long total = 0;

        for (int row = 1; row <= n; row++) {
            for (int value = 1; value <= row; value++) {
                total += value;
            }
            for (int value = row - 1; value >= 1; value--) {
                total += value;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        System.out.println(hillWeight(n));
    }
}
