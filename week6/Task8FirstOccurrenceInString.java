import java.util.Scanner;

public class Task8FirstOccurrenceInString {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String haystack = scanner.next();
        String needle = scanner.next();

        System.out.println(strStr(haystack, needle));
    }
}
