package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        Map<ListNode,Boolean> map = new HashMap<>();
        while (head.next != null){
            if (map.get(head) == null)
                map.put(head,true);
            else
                return head;
            head = head.next;
        }
        return null;
    }
}
