package leetcode;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int min = binSearch(nums,8);
        int max = binSearch(nums,target + 1) - 1;
        if (min == nums.length||nums[min]!=target)
            return new int[]{-1,-1};
        return new int[]{min,max};
    }
    public int binSearch(int[] nums,int target){
        int lo = 0,hi = nums.length;
        int mid = -1;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] >= target)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}
