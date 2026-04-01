import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task7JavaHashset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        Set<String> pairs = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String left = s.next();
            String right = s.next();
            pairs.add(left + "#" + right);
            System.out.println(pairs.size());
        }
    }
}
