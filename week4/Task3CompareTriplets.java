import java.util.Scanner;

public class Task3CompareTriplets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[3];
        int[] b = new int[3];

        for (int i = 0; i < 3; i++) {
            if (!scanner.hasNextInt()) {
                return;
            }
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            if (!scanner.hasNextInt()) {
                return;
            }
            b[i] = scanner.nextInt();
        }

        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) {
                alice++;
            } else if (a[i] < b[i]) {
                bob++;
            }
        }

        System.out.println(alice + " " + bob);
    }
}
