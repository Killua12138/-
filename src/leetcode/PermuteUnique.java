package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        back(res, nums1, 0);
        System.out.println(res);
        return res;
    }

    private void back(List<List<Integer>> res, Integer[] nums, int index) {
        if (index == nums.length){
            List<Integer> list = new ArrayList<>();
            Collections.addAll(list, nums);
            res.add(list);
        }
        for (int i = index; i < nums.length; i++) {
            if (index != i && nums[i] == nums[index])
                continue;
            if (isSwap(nums,index,i)){
                swap(nums, index, i);
                back(res, nums, index + 1);
                swap(nums,i,index);
            }
        }
    }
    private boolean isSwap(Integer[] nums,int i,int j){
        for (int k = i; k < j; k++){
            if (nums[k] == nums[j])
                return false;
        }
        return true;
    }
    private void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] argv) {
        PermuteUnique test = new PermuteUnique();
        int[] nums = {2, 2, 1,1};
        test.permuteUnique(nums);
    }

}
