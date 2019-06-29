package leetcode;


public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        sumBST(root);
        return root;
    }
    private void sumBST(TreeNode root){
        if (root == null)
            return;
        sumBST(root.right);
        sum = root.val + sum;
        root.val = sum;
        sumBST(root.left);
    }
}
