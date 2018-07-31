// No.95 Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1)return new ArrayList<TreeNode>();
        return genTrees(1, n);
        
    }
    
    public List<TreeNode> genTrees(int start, int end){
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(start>end){  trees.add(null); return trees;}

        for(int rootValue=start;rootValue<=end;rootValue++){
            List<TreeNode> leftSubTrees=genTrees(start,rootValue-1);
            List<TreeNode> rightSubTrees=genTrees(rootValue+1,end);

            for(TreeNode leftSubTree:leftSubTrees){
                for(TreeNode rightSubTree:rightSubTrees){
                    TreeNode root=new TreeNode(rootValue);
                    root.left=leftSubTree;
                    root.right=rightSubTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
