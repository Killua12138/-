package leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        sortColors(nums,0,nums.length - 1);
    }
    private void sortColors(int[] nums,int lo,int hi){
        if (hi <= lo)
            return;
        int lt = lo,i = lt + 1,gt = hi;
        int v = nums[lo];
        while(i <= gt){
            if (nums[i] == v)
                i++;
            else if(nums[i] < v)
                swap(nums,lt++,i++);
            else
                swap(nums,gt--,i);
        }
        sortColors(nums,lo,lt-1);
        sortColors(nums,gt+1,hi);
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] argv){
        SortColors test = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        test.sortColors(nums);
        for (int i : nums)
            System.out.print(i+" ");
    }

}
