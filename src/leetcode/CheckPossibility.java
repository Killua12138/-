package leetcode;

public class CheckPossibility{
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2)
            return true;
        int pre = nums[0];
        int count = (nums[0] < nums[1]) ? 0 : 1;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                if (nums[i] <= pre)
                    nums[i - 1] = pre;
                else
                    nums[i] = nums[i - 1];
                count++;
            }
            if (count == 2)
                return false;
            pre = nums[i];
        }
        return true;
    }
}
