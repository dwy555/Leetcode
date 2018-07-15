// No.92 Reverse Linked List II
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n) return head;
        ListNode start = new ListNode(0),result = start;
        start.next = head;
        for(int i=1;i<m;i++) start = start.next;
        ListNode last = start.next, curr = last.next;
        for(int i=m;i<n;i++){
            ListNode temp = curr.next;
            curr.next = last;
            last = curr;
            curr = temp;
        }
        start.next.next = curr;
        start.next = last;
        return result.next;
    }
}
