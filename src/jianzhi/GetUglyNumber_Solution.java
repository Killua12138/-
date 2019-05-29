package jianzhi;

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int i2 = 0, i3 = 0,i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index;i++){
            int next2 = dp[i2] * 2,next3 = dp[i3] * 3,next5 = dp[i5] * 5;
            dp[i] = Math.min(next5,Math.min(next2,next3));
            if (next2 == dp[i])
                i2++;
            if (next3 == dp[i])
                i3++;
            if (next5 == dp[i])
                i5++;
        }
        return dp[index - 1];
    }
}
