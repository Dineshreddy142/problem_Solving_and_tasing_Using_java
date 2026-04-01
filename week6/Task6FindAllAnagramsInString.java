import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        if (m > n) {
            return result;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < m; i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        if (matches(need, window)) {
            result.add(0);
        }

        for (int i = m; i < n; i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - m) - 'a']--;

            if (matches(need, window)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }

    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String s = scanner.next();
        String p = scanner.next();
        List<Integer> ans = findAnagrams(s, p);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) {
                out.append(' ');
            }
            out.append(ans.get(i));
        }

        System.out.println(out);
    }
}
