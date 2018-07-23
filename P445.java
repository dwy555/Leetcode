// No.445 Add Two Numbers II
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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode n1 = l1, n2 = l2;
        
        while(n1 != null){
            s1.push(n1.val);
            n1 = n1.next;
        }
        while(n2 != null){
            s2.push(n2.val);
            n2 = n2.next;
        }
        int bit = 0;
        ListNode node = null;
        while(!s1.isEmpty() || !s2.isEmpty() || bit != 0){
            int add = 0;
            if(!s1.isEmpty())add += s1.pop();
            if(!s2.isEmpty())add += s2.pop();
            add += bit;
            bit = add/10;
            ListNode newNode = new ListNode(add%10);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }
}
