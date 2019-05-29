package leetcode;

public class MaxDepth {
    static int max = 0;
    public int maxDepth(TreeNode root) {
        max = 0;
        if (root == null)
            return max;
        maxDepth(root,1);
        return max;
    }
    private void maxDepth(TreeNode root,int depth){
        if (max <= depth)
            max = depth;
        if (root == null)
            return;
        maxDepth(root.left,depth++);
        maxDepth(root.right,depth++);
    }
}
