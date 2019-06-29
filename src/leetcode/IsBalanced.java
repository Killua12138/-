package leetcode;

public class IsBalanced {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        maxDeepth(root);
        return isBalanced;
    }
    private int maxDeepth(TreeNode root){
        if (root == null)
            return 0;
        int l = maxDeepth(root.left);
        int r = maxDeepth(root.right);
        if (Math.abs(l - r) > 1){
            isBalanced = false;
        }
        return maxDeepth(root.left) + maxDeepth(root.right) + 1;
    }
}
