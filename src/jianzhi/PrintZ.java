package jianzhi;

import java.util.ArrayList;
import java.util.Stack;

public class PrintZ {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (pRoot == null)
            return res;
        Stack<TreeNode> q1 = new Stack<>();//奇数
        Stack<TreeNode> q2 = new Stack<>();//偶数
        int level = 0;
        q1.push(pRoot);
        while(!q1.isEmpty()||!q2.isEmpty()){
            TreeNode temp;
            if (level % 2 == 0){
                while (!q1.isEmpty()){
                    temp = q1.pop();
                    list.add(temp.val);
                    if (temp.left != null)
                        q2.push(temp.left);
                    if (temp.right != null)
                        q2.push(temp.right);
                }
                res.add(new ArrayList<>(list));
                level++;
                list = new ArrayList<>();
            }
            else{
                while(!q2.isEmpty()){
                    temp = q2.pop();
                    list.add(temp.val);
                    if (temp.right != null)
                        q1.push(temp.right);
                    if (temp.left != null)
                        q1.push(temp.left);
                }
                res.add(new ArrayList<>(list));
                level++;
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
