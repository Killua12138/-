package leetcode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = head;
        ListNode newHead1 = head;
        int size = 0;
        while (newHead.next != null) {
            newHead = newHead.next;
            size++;
        }
        size++;
        for (int i = 0; i < size - n - 1; i++) {
            newHead1 = newHead1.next;
        }
        if (size - n - 1 == -1)
            return head.next;
        newHead1.next = newHead1.next.next;
        return head;
    }
    public static void main(String[] argv){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        RemoveNthFromEnd test = new RemoveNthFromEnd();
        ListNode res = test.removeNthFromEnd(l1,2);
        System.out.println(res.val);
    }
}
