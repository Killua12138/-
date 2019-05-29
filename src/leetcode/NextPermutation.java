package leetcode;

import java.util.Arrays;

/**
 * TODO
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int N = nums.length - 1;
        int i;
        for (i = N; i > 0; i--){
            if (nums[i] > nums[i - 1])
                break;
        }
        int k = i - 1;
        if(i > 0){
            while(i <= N){
                if(nums[k] >= nums[i])
                    break;
                i++;
            }
            swap(nums,k,i - 1);
            Arrays.sort(nums,k + 1,N + 1);
        }
        else{
            Arrays.sort(nums);
        }
    }
    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void main(String[] argv){
        NextPermutation test = new NextPermutation();
        int[] nums = {3,1,2};
        test.nextPermutation(nums);
        for(int i : nums)
            System.out.print(i);
    }

}
