package leetcode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null,cur = head;
        while (cur.next != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        cur.next = pre;
        return cur;
    }
}
