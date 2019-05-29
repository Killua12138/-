package leetcode;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long lo,long hi) {
        if (root == null)
            return true;
        if (root.val >= hi || root.val <= lo)
            return false;
        return isValidBST(root.left,lo,root.val) && isValidBST(root.right,root.val,hi);
    }
}
