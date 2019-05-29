package leetcode;

public class Rotate {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - j - 1][N - i - 1];
                matrix[N - j - 1][N - i - 1] = temp;
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - i - 1][j];
                matrix[N - i - 1][j]=temp;
            }
        }
    }
}
