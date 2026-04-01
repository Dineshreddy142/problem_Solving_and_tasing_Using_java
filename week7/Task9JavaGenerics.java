import java.lang.reflect.Method;
import java.util.Scanner;

public class Task9JavaGenerics {
    static class Printer {
        public <T> void printArray(T[] arr) {
            for (T element : arr) {
                System.out.println(element);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        String[] stringArray = new String[m];
        for (int i = 0; i < m; i++) {
            stringArray[i] = scanner.next();
        }

        Printer printer = new Printer();
        printer.printArray(intArray);
        printer.printArray(stringArray);

        int methodCount = 0;
        for (Method method : Printer.class.getDeclaredMethods()) {
            if (method.getName().equals("printArray")) {
                methodCount++;
            }
        }

        if (methodCount > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }
}
