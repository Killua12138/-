package jianzhi;


import java.util.HashMap;

public class DeleteDuplication {
    //1,2,3,3,4,4,5
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        ListNode pre = new ListNode(-1), next = pHead;
        ListNode newHead = pre;
        while (next !=null){
            int count = 0;
            while (next.next != null && next.val == next.next.val){
                next = next.next;
                count++;
            }
            if (count == 0){
                pre.next = next;
                pre = pre.next;
                next = next.next;
            }
            else
                next = next.next;
        }
        if (pre.next != null)
            pre.next = null;
        return newHead.next;
    }
    public static void main(String[] argv){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        DeleteDuplication test = new DeleteDuplication();
        test.deleteDuplication(l1);
    }

}
