package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++){
            int l = i + 1,r = nums.length - 1;
            while (l < r){
                int sum = nums[l] + nums[r] + nums[i];
                int minus = sum - target;
                if (Math.abs(minus) < Math.abs(res - target))
                    res = sum;
                if (minus < 0)
                    l++;
                if (minus > 0)
                    r--;
                if (minus == 0)
                    return res;
            }
        }
        return res;
    }
    public static void main(String[] argv){
        int[] a = new int[] {1,1,-1,-1,3};
        ThreeSumClosest test = new ThreeSumClosest();
        int res = test.threeSumClosest(a,-1);
        System.out.println(res);
    }

}

