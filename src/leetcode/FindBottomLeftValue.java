package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode left = new TreeNode(0);
        while (!q.isEmpty()) {
            int cnt = q.size();
            left = q.peek();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return left.val;
    }
}
