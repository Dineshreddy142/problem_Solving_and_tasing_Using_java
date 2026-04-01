import java.util.Scanner;

public class Task4RotateString {
    public static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String s = scanner.next();
        String goal = scanner.next();
        System.out.println(rotateString(s, goal));
    }
}
