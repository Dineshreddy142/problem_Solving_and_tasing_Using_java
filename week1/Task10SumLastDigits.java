public class Task10SumLastDigits {
    public static void main(String[] args) {
        int a = 249;
        int b = 386;

        System.out.println("Sum of last digits = " + sumOfLastDigits(a, b));
    }

    public static int sumOfLastDigits(int a, int b) {
        int lastA = Math.abs(a) % 10;
        int lastB = Math.abs(b) % 10;
        return lastA + lastB;
    }
}