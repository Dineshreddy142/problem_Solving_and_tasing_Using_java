import java.util.Scanner;

public class Task8TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transposed = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] result = transpose(matrix);

        for (int i = 0; i < result.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < result[0].length; j++) {
                if (j > 0) {
                    row.append(' ');
                }
                row.append(result[i][j]);
            }
            System.out.println(row);
        }
    }
}
