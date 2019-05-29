package leetcode;

public class SwapPairs{
    public ListNode swapPairs(ListNode head){
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = res.next;
        while (cur != null && cur.next != null){
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
    public static void main(String[] argv){
        ListNode l1 = new ListNode(1);
        SwapPairs test = new SwapPairs();
        ListNode res = test.swapPairs(null);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
