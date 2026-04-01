import java.util.Scanner;

public class Task6GradingStudents {
    private static int roundGrade(int grade) {
        if (grade < 38) {
            return grade;
        }

        int nextMultiple = ((grade / 5) + 1) * 5;
        if (nextMultiple - grade < 3) {
            return nextMultiple;
        }

        return grade;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int grade = scanner.nextInt();
            System.out.println(roundGrade(grade));
        }
    }
}
