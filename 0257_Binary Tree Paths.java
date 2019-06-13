class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, "", res);
        return res;
    }
    
    private void binaryTreePaths(TreeNode root, String cur, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(cur + root.val);
            return;
        }
        binaryTreePaths(root.left, cur + root.val + "->", res);
        binaryTreePaths(root.right, cur + root.val + "->", res);
    }
}
