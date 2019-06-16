package leetcode;

public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n;i ++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
    public static void main(String[] argv){
        StringBuffer str = new StringBuffer("We Are Happy");
        String str2= new String("We Are Happy");
        String str3 = str2.replaceAll(" ","%20");
        str.setCharAt(100,'a');
        StringBuilder str4;
        System.out.println();
    }

}
