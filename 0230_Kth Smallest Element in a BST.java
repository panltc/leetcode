class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int cnt = 1;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (cnt < k) {
                    cnt++;
                } else {
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }
}
