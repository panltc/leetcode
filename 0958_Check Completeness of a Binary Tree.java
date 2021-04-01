class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // flag指示是否遍历到了第一个null结点
        boolean flag = false;

        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            // 如果flag为true，说明已经遍历到了一个null结点，如果当前root不为null，说明某个子树只有右结点，没有左结点，所以不是完全二叉树
            if (flag && root != null) {
                return false;
            }
            // 如果遍历到了一个null结点，将flag置为true，并且跳过本次循环
            if (root == null) {
                flag = true;
                continue;
            }
            queue.offer(root.left);
            queue.offer(root.right);
        }

        return true;
    }
}
