package jianzhi;

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        if (pNode.right != null){
            TreeLinkNode temp = pNode.right;
            while (temp.left != null)
                temp = temp.left;
            return temp;
        }
        else{
            while (pNode.next != null){
                if (pNode.next.left == pNode)
                    return pNode.next;
                else{
                    pNode = pNode.next;
                }
            }
            return null;
        }
    }
}
