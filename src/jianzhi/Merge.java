package jianzhi;

public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newNode = new ListNode(-1),head = newNode;
        while(list1 != null || list2 != null){
            if (list1 == null) {
                newNode.next = list2;
                list2 = list2.next;
            }
            else if (list2 == null) {
                newNode.next = list1;
                list1 = list1.next;
            }
            else if (list1.val < list2.val){
                newNode.next = list1;
                list1 = list1.next;
            }
            else {
                newNode.next = list2;
                list2 = list2.next;
            }
            newNode = newNode.next;
        }
        return head.next;
    }
}
