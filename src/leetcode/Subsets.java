package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0)
            return lists;
        back(lists,new ArrayList<>(),nums,0);
        return lists;
    }
    private void back(List<List<Integer>> lists,List<Integer> list,int[] nums,int index){
        lists.add(list);
        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            back(lists,new ArrayList<>(list),nums,i+ 1);
            list.remove(list.lastIndexOf(nums[i]));
        }
    }
    public static void main(String[] argv){
        Subsets test = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(test.subsets(nums));
    }

}
