class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int cnt = 1;
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                if (cnt < k) {
                    cnt++;
                } else {
                    return root.val;
                }
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return 0;
    }
}
