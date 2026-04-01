import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task10MatrixLayerRotation {
    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> ring = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            for (int j = left; j <= right; j++) {
                ring.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom - 1; i++) {
                ring.add(matrix[i][right]);
            }
            for (int j = right; j >= left; j--) {
                ring.add(matrix[bottom][j]);
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                ring.add(matrix[i][left]);
            }

            int len = ring.size();
            int rot = r % len;

            int idx = 0;
            for (int j = left; j <= right; j++) {
                matrix[top][j] = ring.get((idx + rot) % len);
                idx++;
            }
            for (int i = top + 1; i <= bottom - 1; i++) {
                matrix[i][right] = ring.get((idx + rot) % len);
                idx++;
            }
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = ring.get((idx + rot) % len);
                idx++;
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                matrix[i][left] = ring.get((idx + rot) % len);
                idx++;
            }
        }

        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    row.append(' ');
                }
                row.append(matrix[i][j]);
            }
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        matrixRotation(matrix, r);
    }
}
