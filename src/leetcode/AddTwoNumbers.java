package leetcode;

import java.util.Stack;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        pushStack(l1,s1);
        pushStack(l2,s2);
        int carry = 0;
        ListNode pre = new ListNode(-1);
        while (s1.size() != 0 || s2.size() != 0 || carry != 0){
            int x = (s1.size() == 0) ? 0 : s1.pop();
            int y = (s2.size() == 0) ? 0 : s2.pop();
            int sum = x + y + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = pre.next;
            pre.next = newNode;
        }
        return pre.next;
    }
    private void pushStack(ListNode l,Stack<Integer> s){
        while (l != null){
            s.push(l.val);
            l = l.next;
        }
    }
}
