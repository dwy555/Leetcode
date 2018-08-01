// No.513 Find Bottom Left Tree Value
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()){
            ans = q.peek().val;
            int size = q.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = q.poll();
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
        }
        return ans;
    }
}
