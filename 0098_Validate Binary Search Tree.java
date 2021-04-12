class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 任意一层二叉搜索树的左子树都不存在大于当前根结点值的结点，右子树则不存在小于当前根结点值的结点
     * 所以每一层的根结点都是其左子树的最大值，右子树的最小值
     * int类型的变量有表示范围，所以在初始化最大最小值的时候会被卡边界。而使用Integer类型，可以在初始化时传入null，表示当前不知道最大最小值
     */
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
