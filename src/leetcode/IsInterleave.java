package leetcode;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++){
            for (int j = 0; j < s2.length() + 1; j++){
                if (i + j > s3.length())
                    return false;
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                else{
                    if (dp[i][j - 1])
                        dp[i][j] |= s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    if (dp[i - 1][j])
                        dp[i][j] |= s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[s1.length()][s2.length()] && (s1.length() + s2.length() == s3.length());
    }
    public static void main(String[] argv){
        IsInterleave test = new IsInterleave();
        boolean res = test.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(res);
    }

}
