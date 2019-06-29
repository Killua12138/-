package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfBinaryTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        depth(root);
        return max;
    }
    private int depth(TreeNode root){
        if (root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if (l + r > max)
            max = l + r;
        return Math.max(l,r) + 1;
    }
    private void test(Object o){

    }
    public static void main(String[] argv){
        List<Integer> list = new ArrayList<Integer>();
        list.add(null);
        System.out.println(list.get(0));
    }


}
