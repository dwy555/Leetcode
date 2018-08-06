// No.235 Lowest Common Ancestor of a Binary Search Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int left = Math.min(p.val, q.val), right = Math.max(p.val, q.val);
        while(true){
            if(root.val >= left && root.val <= right)return root;
            if(root.val < left)root = root.right;
            else root = root.left;
        }
    }
}
