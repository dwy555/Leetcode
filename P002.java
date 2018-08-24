// No.2. Add Two Numbers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val+l2.val)%10);
        ListNode p = head;
        int flag = (l1.val+l2.val)/10;
        l1 = l1.next; l2 = l2.next;
        while(l1!= null || l2 != null){
            if(l1 != null){flag += l1.val; l1 = l1.next;}
            if(l2 != null){flag += l2.val; l2 = l2.next;}
            ListNode node = new ListNode(flag%10);
            p.next = node;
            p = node;
            flag = flag/10;
        }
        if(flag == 1){
            ListNode node = new ListNode(flag);
            p.next = node;
            p = node;
        }
        p.next = null;
        return head;
    }
}
