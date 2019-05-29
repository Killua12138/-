package jianzhi;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0)
            return null;
        ListNode head1 = head;
        ListNode ans = null;
        while (head != null){
            if (k <= 1)
                ans = (ans == null) ? head1 : ans.next;
            head = head.next;
            k--;
        }
        return ans;
    }
}
