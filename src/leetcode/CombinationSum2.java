package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        back(res, list, candidates, target, 0);
        return res;
    }

    private void back(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int index) {
        if (target == 0) {
            res.add(list);
            System.out.println(res);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1])
                continue;
            if (target - nums[i] < 0)
                break;
            list.add(nums[i]);
            back(res, new ArrayList<>(list), nums, target - nums[i], i + 1);
            list.remove(list.lastIndexOf(nums[i]));
        }
    }

    private boolean isContain(int[] nums, int i, int j) {
        for (int k = i; k < j; k++) {
            if (nums[k] == nums[j])
                return true;
        }
        return false;
    }

    public static void main(String[] argv) {
        CombinationSum2 test = new CombinationSum2();
        int[] nums = {1,1,2,2,2,5};
        test.combinationSum2(nums, 5);
    }

}
