// Approach 1: iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 首先如果root不为空，才会将其加入栈中。其他情况下，只需要判断栈是否为空来确定是否遍历完了二叉树
        while (!stack.isEmpty() || root != null) {
            // 只要root不为空，就将当前结点压入栈中，并遍历左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 如果root为空，就弹出一个结点，并加入结果集，然后遍历右子树
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}

// Approach 2: recursive
class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }
}
