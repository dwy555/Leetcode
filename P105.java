// No.105. Construct Binary Tree from Preorder and Inorder Traversal
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
    
    int index = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i],i);
        }
        return builChidTree(preorder,map,0,inorder.length-1);
    }
    
    public TreeNode builChidTree(int[] preorder, Map<Integer, Integer> map, int start, int end){
        if(start > end)return null;
        index++;
        TreeNode node = new TreeNode(preorder[index]);
        int in_index = map.get(preorder[index]);
        node.left = builChidTree(preorder, map, start, in_index-1);
        node.right = builChidTree(preorder, map, in_index + 1, end);
        return node;
    }
}
