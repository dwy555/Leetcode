// No.143. Reorder List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)return;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int num = 1;
        while(node != null){
            map.put(num++,node);
            node = node.next;
        }
        int left = 1, right = map.size();
        while(left < right){
            map.get(right).next = map.get(left).next;
            map.get(left).next = map.get(right);
            left++;
            right--;
        }
        map.get(left).next = null;
    }
}
