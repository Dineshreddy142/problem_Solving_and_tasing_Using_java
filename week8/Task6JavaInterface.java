import java.util.Scanner;

public class Task6JavaInterface {
    interface AdvancedArithmetic {
        int divisorSum(int n);
    }

    static class MyCalculator implements AdvancedArithmetic {
        @Override
        public int divisorSum(int n) {
            int sum = 0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    sum += i;
                    if (i != n / i) {
                        sum += n / i;
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        AdvancedArithmetic calculator = new MyCalculator();
        System.out.println("I implemented: AdvancedArithmetic");
        System.out.println(calculator.divisorSum(n));
    }
}
