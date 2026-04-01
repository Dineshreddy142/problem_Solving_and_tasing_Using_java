import java.util.Scanner;

public class Task1StringHalvesAlike {
    private static boolean isVowel(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public static boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int balance = 0;

        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) {
                balance++;
            }
            if (isVowel(s.charAt(i + mid))) {
                balance--;
            }
        }

        return balance == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String s = scanner.next();
        System.out.println(halvesAreAlike(s));
    }
}
