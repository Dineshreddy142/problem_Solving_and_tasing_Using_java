import java.util.Scanner;

public class Task7NthPrime {
    public static int nthPrime(int n) {
        if (n <= 0) {
            return -1;
        }

        int count = 0;
        int candidate = 1;

        while (count < n) {
            candidate++;
            if (isPrime(candidate)) {
                count++;
            }
        }

        return candidate;
    }

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        if (x % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        System.out.println(nthPrime(n));
    }
}
