// No.538. Convert BST to Greater Tree
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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        add(root);
        return root;
    }
    private void add(TreeNode node){
        if(node == null)return;
        convertBST(node.right);
        int tmp = node.val;
        node.val += sum;
        sum += tmp;
        convertBST(node.left);
    }
}
