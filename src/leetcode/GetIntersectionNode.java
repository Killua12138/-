package leetcode;


public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA,h2 = headB;
        int disa = 0,disb = 0;
        while(headA != null){
            headA = headA.next;
            disa++;
        }
        while(headB != null){
            headB = headB.next;
            disb++;
        }
        int dis = disa - disb;
        if (dis < 0){
            dis = -dis;
            while (dis-- != 0)
                h2 = h2.next;
        }
        else if (dis > 0){
            while (dis-- != 0)
                h1 = h1.next;
        }
        while(h1 != null && h2 !=null){
            if (h1 == h2)
                return h1;
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }
}
