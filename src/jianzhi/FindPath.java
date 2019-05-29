package jianzhi;

import java.util.ArrayList;

public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        back(lists,list,target - root.val,root);
        return lists;
    }
    private void back(ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> list,int target,TreeNode root){
        if (root == null)
            return;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
            return;
        }
        back(lists,new ArrayList<>(list),target - root.val,root.left);
        back(lists,new ArrayList<>(list),target - root.val,root.right);
        list.remove(list.lastIndexOf(root.val));
    }
}
