package leetcode;

public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumCount(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    private int pathSumCount(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int count = 0;
        if (sum == root.val)
            count++;
        return pathSumCount(root.left,sum - root.val) + pathSumCount(root.right,sum - root.val) + count;
    }
}
