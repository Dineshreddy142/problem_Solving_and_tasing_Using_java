public class Task7DigitSumOption {
    public static void main(String[] args) {
        int number = 1234567;

        System.out.println("Sum of even digits = " + digitSum(number, true));
        System.out.println("Sum of odd digits = " + digitSum(number, false));
    }

    public static int digitSum(int number, boolean sumEvenDigits) {
        int n = Math.abs(number);
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;

            if (sumEvenDigits && digit % 2 == 0) {
                sum += digit;
            }

            if (!sumEvenDigits && digit % 2 != 0) {
                sum += digit;
            }

            n /= 10;
        }

        return sum;
    }
}