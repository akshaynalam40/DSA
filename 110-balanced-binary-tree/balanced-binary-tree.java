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
    public int findheight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=findheight(root.left);
        int right=findheight(root.right);
        return 1+Math.max(left,right);
    }
    public boolean check(TreeNode root){
        if(root==null){
            return true;
        }
        int l=findheight(root.left);
        int  r=findheight(root.right);
        if(Math.abs(l-r)>1){
            return false;
        }

        boolean left=check(root.left);
        boolean  right=check(root.right);

        if(!left || !right){
            return false;
        }

        return true;
    }
    public boolean isBalanced(TreeNode root) {
        boolean ans=check(root);
        return ans;
        
    }
}