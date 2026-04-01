public class Task8NthFibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n + "th Fibonacci number = " + nthFibonacci(n));
    }

    public static long nthFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        long prev = 0;
        long curr = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}