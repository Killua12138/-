package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates.length == 0)
            return lists;
        List<Integer> list = new ArrayList<>();
        back(lists,list,candidates,target,0,0);
        return lists;
    }
    public void back(List<List<Integer>> lists,List<Integer> list,int[] nums,int target,int sum,int index){
        if(sum == target){
            lists.add(list);
            return;
        }
        if(sum > target)
            return;
        for (int i = index;i < nums.length;i++){
            list.add(nums[i]);
            back(lists,new ArrayList<>(list),nums,target,sum+nums[i],i);
            list.remove(list.lastIndexOf(nums[i]));
        }
    }
    public static void main(String[] argv){
        CombinationSum test = new CombinationSum();
        int[] nums = {2,3,6,7};
        System.out.println(test.combinationSum(nums,7));
    }

}
