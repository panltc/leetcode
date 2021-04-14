// Approach 1: iterative
class Solution {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        // 在累加中，每个结点真正代表的值其实是每个结点的父节点值乘以10再加上该结点的值，所以用两个队列来分别表示结点和结点代表的值
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        queue1.offer(root);
        queue2.offer(root.val);
        while (!queue1.isEmpty()) {
            // 每次循环弹出一个结点和该结点代表的值
            root = queue1.poll();
            int data = queue2.poll();

            // 如果该结点为叶结点，说明已经到终点了，直接累加到结果上
            if (root.left == null && root.right == null) {
                res += data;
            } else {
                // 如果左右子树不为空，那么在将左右结点加入队列的时候，需要将当前结点的值（即左右结点的父节点）乘以10再加上左右结点的值，并加入队列
                if (root.left != null) {
                    queue1.offer(root.left);
                    queue2.offer(data * 10 + root.left.val);
                }
                if (root.right != null) {
                    queue1.offer(root.right);
                    queue2.offer(data * 10 + root.right.val);
                }
            }
        }

        return res;
    }
}

// Approach 2: recursive
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int data) {
        if (root == null) {
            return 0;
        }
        
        // 在累加中，每个结点真正代表的值其实是每个结点的父节点值乘以10再加上该结点的值，上一层递归传递过来的data就是父节点代表的值
        int sum = data * 10 + root.val;
        // 如果该结点为叶结点，说明已经到终点了，直接返回sum，即该结点代表的值
        if (root.left == null && root.right == null) {
            return sum;
        }

        // 如果不是叶结点，则继续递归调用
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }
}
