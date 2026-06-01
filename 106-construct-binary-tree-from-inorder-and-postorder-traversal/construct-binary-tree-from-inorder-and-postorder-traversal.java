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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length){
            return null;
        }
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root= builtTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
        return root;
    }
    public TreeNode builtTree(int [] inorder,int is, int ie,int postorder[],int ps,int pe, HashMap<Integer,Integer>hm){
        if(is>ie || ps>pe){
            return null;
        }
        TreeNode root=new TreeNode(postorder[pe]);
         int inRoot=hm.get(root.val);
        int numsLeft=inRoot-is;
        root.left=builtTree(inorder,is,inRoot-1,postorder,ps,ps+numsLeft-1,hm);
        root.right=builtTree(inorder,inRoot+1,ie,postorder,ps+numsLeft,pe-1,hm);
        return root;
    }
}