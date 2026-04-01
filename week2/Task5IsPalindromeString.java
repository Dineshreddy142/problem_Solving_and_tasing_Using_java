import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task5IsPalindromeString {
    private static boolean isPalindrome(String value) {
        int left = 0;
        int right = value.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(value.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(value.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(value.charAt(left)) != Character.toLowerCase(value.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                lines.add(line.trim());
            }
        }

        if (lines.isEmpty()) {
            return;
        }

        int start = 0;
        int cases = 1;

        try {
            int t = Integer.parseInt(lines.get(0));
            if (lines.size() - 1 >= t) {
                cases = t;
                start = 1;
            }
        } catch (NumberFormatException ignored) {
            cases = 1;
            start = 0;
        }

        for (int i = 0; i < cases && start + i < lines.size(); i++) {
            System.out.println(isPalindrome(lines.get(start + i)) ? "YES" : "NO");
        }
    }
}
