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
    ArrayList<String>al=new ArrayList<>();;
    ArrayList<String>list=new ArrayList<>();;
    public boolean isSameTree(TreeNode p, TreeNode q) {
         preorderp(p);
         preorderq(q);
         if(al.size()!=list.size()){
            return false;
         }
         for(int i=0;i<al.size();i++){
              if(!al.get(i).equals(list.get(i))){
                return false;
            }
         }
         return true;
    }
    public void preorderp(TreeNode p){
           
             if(p==null){
                al.add("null");
                return ;
             }
            al.add(String.valueOf(p.val));
            preorderp(p.left);
            preorderp(p.right);
        
    }
    public void  preorderq(TreeNode q){
             if(q==null){
                list.add("null");
                return ;
             }
            list.add(String.valueOf(q.val));
            preorderq(q.left);
            preorderq(q.right);
        
    }

}