/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode>q= new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node =q.poll();
            if(node==null){
                res.append("n").append(" ");
                continue;
            }
            res.append(node.val).append(" ");
            q.offer(node.left);
            q.offer(node.right);

        }
        return res.toString();

        
    }
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty()){
            return null;

        }
        String values[]=data.split(" ");
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent=q.poll();
            if(!values[i].equals("n")){
                TreeNode leftnode=new TreeNode(Integer.parseInt(values[i]));
                parent.left=leftnode;
                q.offer(leftnode);

            }
            i++;
            if(i<values.length && !values[i].equals("n")){
                TreeNode rightnode=new TreeNode(Integer.parseInt(values[i]));
                parent.right=rightnode;
                q.offer(rightnode);
            }
        }
        return root;
}
        
    }
    

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));