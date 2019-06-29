package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()){
            TreeNode node = s.pop();
            if (node == null) continue;
            res.add(node.val);
            s.push(node.left);
            s.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
