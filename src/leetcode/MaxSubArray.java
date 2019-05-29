package leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int lo = 0, hi = 0,max = nums[0],sum = 0;
        boolean isFind = false;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if (sum >= max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
