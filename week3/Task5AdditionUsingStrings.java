import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5AdditionUsingStrings {
    public static String addStrings(String a, String b) {
        return new BigInteger(a).add(new BigInteger(b)).toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tokens = new ArrayList<>();

        while (scanner.hasNext()) {
            tokens.add(scanner.next());
        }

        if (tokens.isEmpty()) {
            return;
        }

        if (tokens.size() >= 3 && tokens.get(0).matches("\\d+")) {
            int t = Integer.parseInt(tokens.get(0));
            if (tokens.size() == 1 + 2 * t) {
                int index = 1;
                for (int i = 0; i < t; i++) {
                    System.out.println(addStrings(tokens.get(index), tokens.get(index + 1)));
                    index += 2;
                }
                return;
            }
        }

        if (tokens.size() >= 2) {
            System.out.println(addStrings(tokens.get(0), tokens.get(1)));
        }
    }
}
