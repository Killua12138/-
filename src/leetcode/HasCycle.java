package leetcode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head,fast = head.next;
        while (fast != slow){
            if (fast == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
    public static void main(String[] argv){
        int[] a = {2,1};
        int i = 0;
        if (a[i++] > 1)
            System.out.println(i);
    }

}
