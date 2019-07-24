class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBinaryTree(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int pos = i;
        for (int k = i; k <= j; k++) {
            if (nums[k] > nums[pos]) {
                pos = k;
            }
        }
        TreeNode root = new TreeNode(nums[pos]);
        root.left = constructMaximumBinaryTree(nums, i, pos - 1);
        root.right = constructMaximumBinaryTree(nums, pos + 1, j);
        return root;
    }
}
