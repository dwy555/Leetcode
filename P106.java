// No.106. Construct Binary Tree from Inorder and Postorder Traversal
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
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++)
            map.put(inorder[i],i);
        index = len;
        return buildChildTree(postorder, map, 0, len-1);
    }
    
    public TreeNode buildChildTree(int[] postorder, Map<Integer,Integer> map, int left, int right){
        if(left > right)return null;
        index --;
        TreeNode node = new TreeNode(postorder[index]);
        int in_index = map.get(postorder[index]);
        node.right = buildChildTree(postorder, map, in_index+1, right);
        node.left = buildChildTree(postorder, map, left, in_index-1);
        return node;
    }
}
