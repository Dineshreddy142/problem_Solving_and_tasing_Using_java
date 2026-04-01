import java.util.Scanner;

public class Task9GetCodeThroughStrings {
    public static String getCode(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append((int) text.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            return;
        }

        String input = scanner.nextLine();
        if (input.isEmpty() && scanner.hasNextLine()) {
            input = scanner.nextLine();
        }

        System.out.println(getCode(input));
    }
}
