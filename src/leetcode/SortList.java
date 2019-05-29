package leetcode;


import util.Sort;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        int a = l1.val,b = l2.val;
        ListNode head;
        if (a < b){
            head = new ListNode(l1.val);
            l1 = l1.next;
        }
        else{
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode temp = head;
        while(l1 != null || l2 != null){
            if (l1 == null){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if (l2 == null){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                if (l1.val < l2.val) {
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                else{
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            head = head.next;
        }
        return temp;
    }
    public static void main(String[] argv){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next  = new ListNode(3);
        SortList test = new SortList();
        test.sortList(head);
    }

}
