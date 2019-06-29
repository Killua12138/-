package leetcode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenhead = even;
        while (even != null && even.next != null){
            even.next = even.next.next;
            even = even.next;
            odd.next = odd.next.next;
            odd = odd.next;
        }
        odd.next = even.next;
        return head;
    }
     public static void main(String[] argv){
        OddEvenList test = new OddEvenList();
        ListNode l1 = new ListNode(1);
        test.oddEvenList(l1);
    }

}
