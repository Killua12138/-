package jianzhi;

import java.util.List;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newNode = null;
        ListNode pNode = head;
        ListNode pPre = null;
        while(pNode != null){
            ListNode pNext = pNode.next;
            if (pNext == null)
                newNode = pNode;
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return newNode;
    }
}