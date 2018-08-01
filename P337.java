// No.337 House Robber III
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
    public int rob(TreeNode root) {
        if(root == null)return 0;
        int m1 = 0, m2 = 0;
        if(root.left != null){
            m1 += rob(root.left);
            if(root.left.left != null)m2 += rob(root.left.left);
            if(root.left.right != null)m2 += rob(root.left.right);
        }
        if(root.right != null){
            m1 += rob(root.right);
            if(root.right.left != null)m2 += rob(root.right.left);
            if(root.right.right != null)m2 += rob(root.right.right);
        }
        return Math.max(m1, root.val + m2);
    }
}
