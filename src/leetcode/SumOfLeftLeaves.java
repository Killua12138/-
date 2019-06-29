package leetcode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(null,root);
    }
    private int sum (TreeNode pre,TreeNode cur){
        if (cur == null)
            return 0;
        if (cur.left == null && cur.right == null && pre != null && cur == pre.left)
            return cur.val;
        return sum(cur,cur.left) + sum(cur,cur.right);
    }
}
