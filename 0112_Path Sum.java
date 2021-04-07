class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 如果左右子树都为空，判断targetSum和当前结点值是否相同
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // 如果左右子树至少一个存在，就递归查找左右子树，本层递归需要减去当前结点的值，任意一个结果正确即为true，所以为或
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
