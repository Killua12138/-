package leetcode;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        int rank = rank(root.left) + 1;
        if (rank == k)
            return root.val;
        else if (rank < k)
            return kthSmallest(root.right, k - rank);
        else
            return kthSmallest(root.left,k);
    }
    private int rank(TreeNode root){
        if (root == null)
            return 0;
        return rank(root.left) + rank(root.right) + 1;
    }
}
