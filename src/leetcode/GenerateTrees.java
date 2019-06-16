package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }
    private List<TreeNode> generateTrees(int s,int e){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (s > e){
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++){
            List<TreeNode> leftSubTree = generateTrees(s,i - 1);
            List<TreeNode> rightSubTree = generateTrees(i + 1,e);
            for (TreeNode left : leftSubTree){
                for (TreeNode right : rightSubTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
