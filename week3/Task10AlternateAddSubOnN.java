import java.util.Scanner;

public class Task10AlternateAddSubOnN {
    public static long alternateAddSub(int n) {
        long result = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                result += i;
            } else {
                result -= i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        System.out.println(alternateAddSub(n));
    }
}
