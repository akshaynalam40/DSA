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
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return root;
        }
        changeTree(root);
        return root;
        
    }
    public void changeTree(TreeNode root){
       if(root==null){
        return ;
       }
       changeTree(root.right);
       sum+=root.val;
       root.val=sum;
       changeTree(root.left);
    }
}