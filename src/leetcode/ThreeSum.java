package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int target = -nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -target && i != 0)
                continue;
            int l = i + 1, r = nums.length - 1;
            target = -nums[i];
            System.out.println(target);
            while (l < r) {
                l = (l == i) ? l + 1 : l;
                r = (r == i) ? r - 1 : r;
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(nums[i]);
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    res.add(list);
                }
                if (sum < target) l++;
                else r--;
            }
        }
        return res;
    }

    public static void main(String[] argv) {
        ThreeSum test = new ThreeSum();
        int nums[] = {-1, 0, 1, 2, 2, -1, 4, -4, 7, 3, -2, -7, -6, -2};
        System.out.println(test.threeSum(nums));
    }
}
