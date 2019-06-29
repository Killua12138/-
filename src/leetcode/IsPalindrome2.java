package leetcode;

public class IsPalindrome2 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head,slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode r = head,l = reverse(slow.next);
        slow.next = null;
        while (r!= null && l != null){
            if (r.val != l.val)
                return false;
            r = r.next;
            l = l.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head.next!= null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }
}
