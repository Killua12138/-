package leetcode;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0;i < nums.length;i++){
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }
    public static void main(String[] argv){
        int[] a = {1,2,3,4};
        int[] b = a;
        for (int i : b){
            System.out.println(i);
        }
    }

}
