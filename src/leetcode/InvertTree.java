package leetcode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.right = invertTree(l);
        root.left = invertTree(r);
        return root;
    }
}
