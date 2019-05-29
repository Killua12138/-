package leetcode;

import java.util.List;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode cur = head,pre = head;
        ListNode l,r,newhead;
        l = r = newhead = head;
        ListNode newlist = new ListNode(-1);
        boolean flag = true;
        while (true){
            int count = 0;
            while (r != null && count < k){
                r = r.next;
                count++;
            }
            if (count == k){
                pre = r;
                for (int i = 0; i < k;i++){
                    ListNode temp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = temp;
                }
                if (flag){
                    flag = false;
                    newhead = pre;
                }
                //反转完毕连接上一个链表，初始时上一个链表为空，newlist为上一次反转完之后的尾节点，即反转前的头节点
                newlist.next = pre;
                newlist = l;
                l = r;
            }
            else
                return newhead;
        }
    }
    public static void main(String[] argv){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        ReverseKGroup test = new ReverseKGroup();
        ListNode head = test.reverseKGroup(l1,2);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
