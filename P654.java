// No.654. Maximum Binary Tree
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len =nums.length;
        if(len == 0)return null;
        TreeNode root = new TreeNode(nums[0]);
        TreeNode pre = root;
        TreeNode cur;
        for(int i = 1; i < len; i++){
            cur = new TreeNode(nums[i]);
            if(nums[i] > root.val){
                cur.left = root;
                root = cur;
                pre = root;
            }else if(nums[i] < pre.val){
                pre.right = cur;
                pre = cur;
            }else{
                TreeNode node = root;
                while(node.right.val > cur.val){
                    node = node.right;
                }
                cur.left = node.right;
                node.right = cur;
                pre = cur;
            }
                
        }
        return root;
    }
    
}
