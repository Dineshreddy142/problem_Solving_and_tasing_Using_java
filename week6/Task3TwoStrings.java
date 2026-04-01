import java.util.Scanner;

public class Task3TwoStrings {
    private static String twoStrings(String s1, String s2) {
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s1.length(); i++) {
            seen[s1.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (seen[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(twoStrings(s1, s2));
        }
    }
}
