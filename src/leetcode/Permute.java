package leetcode;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0)
            return lists;
        List<Integer> list = new ArrayList<>();
        back(lists, list, nums);
        return lists;
    }

    private void back(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            back(lists, new ArrayList<>(list), nums);
            list.remove(list.lastIndexOf(nums[i]));
        }
    }
    public static void main(String[] argv){
        Permute test = new Permute();
        int[] nums = {1,2,3};
        System.out.println(test.permute(nums));
    }
}
