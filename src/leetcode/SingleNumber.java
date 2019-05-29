package leetcode;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;
        int target = 0;
        for (int i = 0; i < nums.length; i++){
            target = target ^ nums[i];
        }
        return target;
    }
}
