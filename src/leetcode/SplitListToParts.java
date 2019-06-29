package leetcode;

public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int length = 0;
        ListNode node = root;
        while (node != null){
            node = node.next;
            length++;
        }
        int count = length % k;
        int base = length / k;
        for (int i = 0; i< k; i++){
            res[i] = root;
            if (count != 0){
                root = splitSub(root,base + 1);
                count --;
            }else
                root = splitSub(root,base);
        }
        return res;
    }
    private ListNode splitSub(ListNode root,int length){
        if (root == null || length == 0)
            return null;
        while (--length != 0){
            root = root.next;
        }
        ListNode res = root.next;
        root.next = null;
        return res;
    }
}
