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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>al= new ArrayList<>();
         return preorder(al,root); 
    }
    public List<Integer> preorder(List<Integer> list,TreeNode root){
        if(root==null){
            return list;
        }
        preorder(list,root.left);
        list.add(root.val);
        preorder(list,root.right);

      return list;
        
    }
}