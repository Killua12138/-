package leetcode;

public class Search {
    //4,5,6,7,0,1,2
    public int search(int[] nums, int target) {
        int lo = 0,hi = nums.length;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (target == nums[mid])
                return mid;
            if (target == nums[lo])
                return lo;
            if (target == nums[hi])
                return hi;
            if (nums[mid] > nums[lo]){
                if (nums[mid] < target)
                    lo = mid + 1;
                else{
                    if (nums[lo] < target)
                        hi = mid - 1;
                    else
                        lo = mid + 1;
                }
            }
            else{
                if (nums[mid] > target)
                    hi = mid - 1;
                else{
                    if (nums[hi] > target)
                        lo = mid + 1;
                    else
                        hi = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] argv){
        Search test = new Search();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(test.search(nums,0));
    }

    //4,5,6,7,0,1
    //7 8 0 1 2 3 4 5 6  7
    //2 1
    // 1 2 3 4 5 6 7
}
