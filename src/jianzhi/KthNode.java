package jianzhi;

import java.util.Stack;

public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k){
        Stack<TreeNode> s = new Stack<>();
        int count = 0;
        while (pRoot != null || !s.isEmpty()){
            while (pRoot != null){
                s.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!s.isEmpty()){
                pRoot = s.pop();
                count++;
                if (count == k)
                    return pRoot;
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
