package leetcode;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1,pre = 0;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            cur--;
            list.add(node.val);
            if (node.left != null){
                pre++;
                queue.offer(node.left);
            }
            if (node.right != null){
                pre++;
                queue.offer(node.right);
            }
            if (cur == 0){
                lists.add(new ArrayList<>(list));
                cur = pre;
                list = new ArrayList<>();
            }
            System.out.println(queue);
        }
        lists.add(new ArrayList<>(list));
        return lists;
    }
    public static void main(String[] argv){
        while(Math.random()!=0.0);
        System.out.println(0.0);
    }

}
