import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task10NaivePatternSearch {
    public static List<Integer> search(String pat, String txt) {
        List<Integer> matches = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && txt.charAt(i + j) == pat.charAt(j)) {
                j++;
            }
            if (j == m) {
                matches.add(i);
            }
        }

        return matches;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.hasNextLine() ? scanner.nextLine() : "";
        String pat = scanner.hasNextLine() ? scanner.nextLine() : "";

        List<Integer> result = search(pat, txt);
        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(result.get(i));
        }
        System.out.println(sb);
    }
}
