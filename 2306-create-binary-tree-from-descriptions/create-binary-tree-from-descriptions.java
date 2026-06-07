class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int m = descriptions.length;
        HashMap<Integer, TreeNode>hm=new HashMap<>();
        HashSet<Integer> children=new HashSet<>();
        for(int i=0;i<m;i++) {
            int parentVal =descriptions[i][0];
            int childVal =descriptions[i][1];
            if(!hm.containsKey(parentVal)){
                hm.put(parentVal,new TreeNode(parentVal));
            }
            TreeNode node = hm.get(parentVal);
            if(!hm.containsKey(childVal)){
                hm.put(childVal, new TreeNode(childVal));
            }
            TreeNode newNode = hm.get(childVal);
            if(descriptions[i][2]==0)
            {
                node.right = newNode;
            } 
            else 
            {
                node.left = newNode;
            }

            children.add(childVal);
        }

        for(int i = 0;i<m;i++){
            int parentVal = descriptions[i][0];
            if(!children.contains(parentVal)) {
                return hm.get(parentVal);
            }
        }

        return null;
    }
}