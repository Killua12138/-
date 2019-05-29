package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int count = 1,cur = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            count--;
            cur--;
            if (temp.left != null){
                queue.offer(temp.left);
                count++;
            }

            if (temp.right != null){
                queue.offer(temp.right);
                count++;
            }
            if (cur == 0){
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                cur = count;
            }
        }
        return res;
    }
}
