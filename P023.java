// No.23. Merge k Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode o1,ListNode o2){
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        ListNode p = new ListNode(0);
        ListNode q = p;
        for (ListNode node:lists)
            if (node != null)
                queue.add(node);
        while (!queue.isEmpty()){
            q.next = queue.poll();
            q = q.next;
            if (q.next != null)
                queue.add(q.next);
        }
        return p.next;
    }
}
