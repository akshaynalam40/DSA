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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode ans=inorder(root,k);
        return ans.val;
        
    }
    int cnt=0;
    public TreeNode inorder(TreeNode root,int k){
         if(root==null){
            return null;
         }
         TreeNode left=inorder(root.left,k);
         if(left!=null){
            return left;
         }
         cnt++;
         if(cnt==k){
            return root;
         }
        
         return  inorder(root.right,k);


    }
}