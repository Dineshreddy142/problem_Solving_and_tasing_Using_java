import java.util.Scanner;

public class Task5MarsExploration {
    public static int marsExploration(String s) {
        int changed = 0;
        char[] expected = {'S', 'O', 'S'};

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != expected[i % 3]) {
                changed++;
            }
        }

        return changed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String s = scanner.next();
        System.out.println(marsExploration(s));
    }
}
