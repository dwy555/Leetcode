// No.606. Construct String from Binary Tree
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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t != null)
            toStr(t);
        return sb.toString();
    }
    
    public void toStr(TreeNode t){
        sb.append(t.val);
        if(t.left == null && t.right == null)return;
        if(t.left == null && t.right != null){
            sb.append("()");
            sb.append("(");
            toStr(t.right);
            sb.append(")");
        }else if(t.left != null){
            sb.append("(");
            toStr(t.left);
            sb.append(")");
            if(t.right != null){
                sb.append("(");
                toStr(t.right);
                sb.append(")");
            }
        }
    }
    
}
