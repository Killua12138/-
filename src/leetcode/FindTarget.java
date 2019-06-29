package leetcode;

import java.util.ArrayList;

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        getMidOrder(root,list);
        int head = 0,tail = list.size() - 1;
        while (head >= tail){
            int num1 = list.get(head);
            int num2 = list.get(tail);
            int sum = num1 + num2;
            if (sum > k)
                tail --;
            else if (sum < k)
                head ++;
            else
                return true;
        }
        return false;
    }
    private void getMidOrder(TreeNode root, ArrayList<Integer> list){
        if (root == null)
            return;
        getMidOrder(root.left,list);
        list.add(root.val);
        getMidOrder(root.right,list);
    }
}
