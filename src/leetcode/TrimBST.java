package leetcode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val > R)
            root = trimBST(root.left,L,R);
        else if (root.val < L)
            root = trimBST(root.right,L,R);
        else{
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
        }
        return root;
    }
}
