// No.102 Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)return ans;
        Deque<TreeNode> que = new LinkedList<>();
        TreeNode p = root;
        que.add(p);
        while(!que.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int count = que.size();
            for(int i = 0; i < count; i++){
                p = que.poll();
                if(p.left!= null)que.add(p.left);
                if(p.right!= null)que.add(p.right);
                list.add(p.val);
            }
            ans.add(list); 
        }
        return ans;
    }
}
