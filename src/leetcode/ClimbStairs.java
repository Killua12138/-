package leetcode;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        int cur = 1,pre = 1;
        for (int i = 0; i < n - 1; i++){
            int temp = cur;
            cur = pre + cur;
            pre = temp;
        }
        return cur;
    }
}
