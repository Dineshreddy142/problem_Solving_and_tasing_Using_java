import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task7LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= left) {
                left = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, right);
            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.hasNextLine() ? scanner.nextLine() : "";
        if (s.isEmpty() && scanner.hasNextLine()) {
            s = scanner.nextLine();
        }

        System.out.println(lengthOfLongestSubstring(s));
    }
}
