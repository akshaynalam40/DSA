/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
        TreeNode parent=root;
        if(root==null){
            return new TreeNode(val);
        }
        while(root!=null){
            if(val<root.val){
                if(root.left==null){
                    root.left=node;
                    return parent;
                }
                else{
                    root=root.left;
                }
            }
            else{
                if(root.right==null){
                    root.right=node;
                    return parent;
                }
                else{
                    root=root.right;
                }
            }
        }
        return parent;
        
    }
}