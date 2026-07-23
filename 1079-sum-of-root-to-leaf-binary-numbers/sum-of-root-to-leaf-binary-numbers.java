class Solution {
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return findrecur(root, sb);
    }

    public int findrecur(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return 0;
        }

        sb.append(root.val);

        // Leaf node
        if (root.left == null && root.right == null) {
            int sum = Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
            return sum;
        }

        int left = findrecur(root.left, sb);
        int right = findrecur(root.right, sb);

        // Backtrack
        sb.deleteCharAt(sb.length() - 1);

        return left + right;
    }
}