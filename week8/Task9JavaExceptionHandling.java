import java.util.Scanner;

public class Task9JavaExceptionHandling {
    static class MyCalculator {
        long power(int n, int p) throws Exception {
            if (n == 0 && p == 0) {
                throw new Exception("n and p should not be zero.");
            }
            if (n < 0 || p < 0) {
                throw new Exception("n or p should not be negative.");
            }
            return (long) Math.pow(n, p);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyCalculator myCalculator = new MyCalculator();

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(myCalculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
