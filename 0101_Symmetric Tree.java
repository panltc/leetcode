// Approach 1: iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 二叉树的层序操作适合使用queue
        Queue<TreeNode> queue = new LinkedList<>();
        
        // 将root加入queue，加入两次是为了在一个queue内进行判断操作
        queue.offer(root);
        queue.offer(root);
        // 每次循环处理一层二叉树
        while (!queue.isEmpty()) {
            // 每次都取出两个结点进行比较
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();
            // 如果两个结点都为空，说明已经到了叶结点，跳过即可
            if (root1 == null && root2 == null) {
                continue;
            }
            // 任意一个结点为空，都说明不对称，返回false
            if (root1 == null || root2 == null) {
                return false;
            }
            // 两个结点的值不同，说明不对称，返回false
            if (root1.val != root2.val) {
                return false;
            }
            // 处理完两个结点后，将它们的左右子树交替放入队列中
            queue.offer(root1.left);
            queue.offer(root2.right);
            queue.offer(root1.right);
            queue.offer(root2.left);
        }

        // 遍历全部结点后，如果没有返回false，说明整个二叉树对称，返回true
        return true;
    }
}

// Approach 2: recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }

    // 任意两棵根结点位于同一层的子树进行比较
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        // 如果两棵子树的根结点都为null，那么这两棵子树是对称的
        if (root1 == null && root2 == null) {
            return true;
        }
        // 如果有一颗子树根结点不为null，那么两棵子树不对称
        if (root1 == null || root2 == null) {
            return false;
        }
        // 如果两棵子树都不为null，但根结点的值不同，那么也不对称
        if (root1.val != root2.val) {
            return false;
        }
        // 即使两棵子树的根结点对称了，还需要判断两棵子树的左右子树是否对称
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
