package leetcode;



public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return getMidNode(head,null);
    }
    private TreeNode getMidNode(ListNode s,ListNode e){
        if (s == e)
            return null;
        ListNode fast = s;
        ListNode slow = s;
        while (fast != e && fast.next != e){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = getMidNode(s,slow);
        root.right = getMidNode(slow.next,e);
        return root;
    }
}
