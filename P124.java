// No.124 Binary Tree Maximum Path Sum
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }
    
    public int pathSum(TreeNode node){
        if (node == null) return 0;
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
