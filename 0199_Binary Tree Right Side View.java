class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            // peek方法不取出节点
            res.add(queue.peek().val);
            for (int i = queue.size() - 1; i >= 0; i--) {
                root = queue.poll();
                // 先添加右节点进入队列，那么在循环中对每层进行操作的时候，队列中取出的第一个节点就是该层的最右边的节点
                if (root.right != null) {
                    queue.offer(root.right);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
            }
        }

        return res;
    }
}
