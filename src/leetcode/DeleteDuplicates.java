package leetcode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode fast = head.next,slow = head;
        while (slow.next != null && fast != null){
            if (slow.val == fast.val){
                fast = fast.next;
            }
            else{
                slow.next = fast;
                fast = fast.next;
                slow = slow.next;
            }
        }
        return head;
    }
}
