package jianzhi;

public class Multiply {
    public int[] multiply(int[] A) {
        if (A.length == 1)
            return A;
        int N = A.length;
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = 1;
            for (int j = 0; j < N; j++){
                if (j == i)
                    continue;
                B[i] = B[i] * A[j];
            }
        }
        return B;
    }
}
