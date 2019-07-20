// Approach 1: iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if ((p.val <= cur.val && q.val >= cur.val) || (p.val >= cur.val && q.val <= cur.val)) {
                return cur;
            }
            if (p.val < cur.val) {
                queue.offer(cur.left);
            } else {
                queue.offer(cur.right);
            }
        }
        return null;
    }
}

// Approach 2: recursive
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
