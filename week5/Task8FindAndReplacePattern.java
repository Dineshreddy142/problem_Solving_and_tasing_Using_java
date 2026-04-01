import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task8FindAndReplacePattern {
    private static boolean matches(String word, String pattern) {
        Map<Character, Character> pToW = new HashMap<>();
        Map<Character, Character> wToP = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (pToW.containsKey(p) && pToW.get(p) != w) {
                return false;
            }
            if (wToP.containsKey(w) && wToP.get(w) != p) {
                return false;
            }

            pToW.put(p, w);
            wToP.put(w, p);
        }

        return true;
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        String pattern = scanner.next();

        List<String> result = findAndReplacePattern(words, pattern);
        System.out.println(String.join(" ", result));
    }
}
