package leetcode;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length;
        while (l <= h){
            int mid = l + (h - l) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]){
                if ((mid - 1) % 2 == 0)
                    l = mid + 1;
                else
                    h = mid - 2;
            }
            else if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]){
                if ((mid % 2 == 0))
                    l = mid + 2;
                else
                    h = mid - 1;
            }else
                return nums[mid];
        }
        return 0;
    }
}
