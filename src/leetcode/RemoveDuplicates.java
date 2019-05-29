package leetcode;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (cur != nums[i]){
                nums[len] = nums[i];
                len++;
                cur = nums[i];
            }
        }
        return len;
    }
}
