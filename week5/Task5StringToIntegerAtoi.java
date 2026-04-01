import java.util.Scanner;

public class Task5StringToIntegerAtoi {
    public static int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        long value = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            value = value * 10 + (s.charAt(i) - '0');
            long signed = sign * value;
            if (signed > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (signed < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) (sign * value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.hasNextLine() ? scanner.nextLine() : "";
        System.out.println(myAtoi(s));
    }
}
