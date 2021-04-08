class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeigth = height(root.left);
        int rightHeight = height(root.right);

        // 如果左右子树的高度差大于1，直接返回-1，说明已经不平衡了。自底向上进行判断，如果任意子树不平衡，该结点直接返回-1，即不平衡了
        if (leftHeigth == -1 || rightHeight == -1 || Math.abs(leftHeigth - rightHeight) > 1) {
            return -1;
        }

        // 如果左右子树都平衡，该结点的高度就是两个结点的最大高度加一
        return Math.max(leftHeigth, rightHeight) + 1;
    }
}
