import java.util.Scanner;

public class Task5TimeConversion {
    public static String timeConversion(String s) {
        String period = s.substring(8);
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, 8);

        if ("AM".equals(period)) {
            hour = (hour == 12) ? 0 : hour;
        } else {
            hour = (hour == 12) ? 12 : hour + 12;
        }

        return String.format("%02d%s", hour, rest);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String s = scanner.next();
        System.out.println(timeConversion(s));
    }
}
