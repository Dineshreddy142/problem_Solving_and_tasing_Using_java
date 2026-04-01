import java.util.Scanner;

public class Task6AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        int deletions = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            System.out.println(alternatingCharacters(s));
        }
    }
}
