import java.util.Scanner;

public class Task8GenerateSeriesNthElement {
    public static long nthElement(int n) {
        if (n <= 0) {
            return -1;
        }

        long current = 1;
        for (int i = 2; i <= n; i++) {
            current += (i - 1);
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        System.out.println(nthElement(n));
    }
}
