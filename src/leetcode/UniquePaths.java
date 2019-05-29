package leetcode;

public class UniquePaths {
    private static int[][] dp = new int[101][101];

    static {
        for (int i = 0; i < 33; i++) {
            dp[0][i] = 1;
            dp[i][0] = 1;
        }
        for (int i = 1; i < 33; i++){
            for (int j = 1;j < 33; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
    }

    public int uniquePaths(int m, int n) {
        return dp[m-1][n-1];
    }
    public static void main(String[] argv){
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(33,33));
    }

}
