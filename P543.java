// No.543. Diameter of Binary Tree
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }
    
    public int height(TreeNode node){
        if(node == null)return 0;
        int left = height(node.left);
        int right = height(node.right);
        max = Math.max(left+right,max);
        return 1+Math.max(left,right);
    }
}
