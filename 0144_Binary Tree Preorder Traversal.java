class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return res;
    }
}
