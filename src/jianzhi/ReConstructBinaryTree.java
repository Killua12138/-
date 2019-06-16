package jianzhi;

public class ReConstructBinaryTree {
    static int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length != in.length)
            return null;
        TreeNode root = reConstructBinaryTree(pre,0,pre.length - 1,in,0,in.length - 1);
        return root;
    }
    private TreeNode reConstructBinaryTree(int [] pre,int startpre,int endpre,int [] in,int instart,int inend) {
        if (startpre > endpre || instart > inend)
            return null;
        TreeNode root = new TreeNode(pre[startpre]);
        for (int i = instart; i <= inend; i++){
            if (pre[startpre] == in[i]){
                root.left = reConstructBinaryTree(pre,startpre + 1,startpre + i - instart,in,instart, i - 1);
                root.right = reConstructBinaryTree(pre,i-instart+startpre+1,endpre,in,i + 1,inend);
                break;
            }
        }
        return root;
    }
    public void travel(TreeNode root){
        if  (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        travel(root.left);
        travel(root.right);
    }
    public static void main(String[] argv){
        ReConstructBinaryTree test = new ReConstructBinaryTree();
        int[] a = {1,2,4,7,3,5,6,8};
        int[] b = {4,7,2,1,5,3,8,6};
        TreeNode root = test.reConstructBinaryTree(a,b);
        System.out.println(root.right.val);
        test.travel(root);
    }
}
