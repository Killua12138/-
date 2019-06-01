package leetcode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int length = 1;
        ListNode next = head;
        while (next.next != null){
            length++;
            next = next.next;
        }
        next.next = head;
        int mod = length - k % length;
        while (--mod > 0)
            head = head.next;
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
