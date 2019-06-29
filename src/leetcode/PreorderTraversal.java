package leetcode;

import java.util.*;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            while (cur != null){
                res.add(cur.val);
                if (cur.right != null)
                    s.push(cur.right);
                cur = cur.left;
            }
        }
        return res;
    }
}
