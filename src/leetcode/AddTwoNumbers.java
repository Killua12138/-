package leetcode;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int x = l1.val, y = l2.val;
        ListNode l3 = new ListNode((x + y) % 10);
        carry = (x + y) / 10;
        ListNode res = l3;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null || carry != 0) {
            x = 0;
            y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            l3.next = new ListNode((x + y + carry) % 10);
            l3 = l3.next;
            carry = (x + y + carry) / 10;
        }
        return res;
    }
}
