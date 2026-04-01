import java.util.Scanner;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return n -> (n & 1) != 0;
    }

    public PerformOperation isPrime() {
        return n -> {
            if (n < 2) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            if (n % 2 == 0) {
                return false;
            }
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return n -> {
            if (n < 0) {
                return false;
            }

            int original = n;
            int reversed = 0;

            while (n > 0) {
                reversed = reversed * 10 + (n % 10);
                n /= 10;
            }

            return original == reversed;
        };
    }
}

public class Task2LambdaExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyMath myMath = new MyMath();

        if (!scanner.hasNextInt()) {
            return;
        }

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int condition = scanner.nextInt();
            int number = scanner.nextInt();

            switch (condition) {
                case 1 -> System.out.println(MyMath.checker(myMath.isOdd(), number) ? "ODD" : "EVEN");
                case 2 -> System.out.println(MyMath.checker(myMath.isPrime(), number) ? "PRIME" : "COMPOSITE");
                case 3 -> System.out.println(MyMath.checker(myMath.isPalindrome(), number) ? "PALINDROME" : "NOT PALINDROME");
                default -> System.out.println("INVALID CONDITION");
            }
        }
    }
}
