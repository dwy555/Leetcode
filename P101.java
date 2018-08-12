// No.101. Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        dq.add(root);
        while(!dq.isEmpty()){
            TreeNode left = dq.poll();
            TreeNode right = dq.poll();
            if(left.val != right.val)return false;
            if(left.left != null && right.right != null){
                dq.add(left.left);
                dq.add(right.right);
            }else if(left.left != null || right.right != null){
                return false;
            }
            
            if(left.right != null && right.left != null){
                dq.add(left.right);
                dq.add(right.left);
            }else if(left.right != null || right.left != null){
                return false;
            }
        }
        return true;
    }
    
    
}
