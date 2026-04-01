import java.util.Scanner;

public class Task6AllDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] count = new int[10];

        while (scanner.hasNext()) {
            String token = scanner.next();
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                if (Character.isDigit(c)) {
                    count[c - '0']++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (i > 0) {
                result.append(' ');
            }
            result.append(count[i]);
        }

        System.out.println(result);
    }
}
