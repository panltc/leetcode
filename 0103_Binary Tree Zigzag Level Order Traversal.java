class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 如果root为空，直接返回
        if (root == null) {
            return res;
        }
        // 层序遍历，使用队列来记录每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();

        // 先将当前节点入队
        queue.offer(root);
        // flag为true代表该层遍历顺序从左往右，反之，从右往左
        boolean flag = true;
        // 如果队列不空，说明还没有遍历完二叉树。每一次循环都是在对一层二叉树进行操作
        while (!queue.isEmpty()) {
            // list列表记录一层二叉树的数据
            List<Integer> list = new ArrayList<>();
            // 遍历一层二叉树的所有节点
            for (int i = queue.size() - 1; i >= 0; i--) {
                // 取出该层二叉树的一个节点进行操作
                root = queue.poll();
                // 如果flag为true，则插入列表尾部，否则插入头部
                if (flag) {
                    list.add(root.val);
                } else {
                    list.add(0, root.val);
                }
                // 如果该节点左子树不空，加入队列
                if (root.left != null) {
                    queue.offer(root.left);
                }
                // 如果该节点右子树不空，加入队列
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            // 将该层二叉树的数据加入结果集
            res.add(list);
            // 下一层遍历需要改变遍历方向，将flag取反
            flag = !flag;
        }

        return res;
    }
}
