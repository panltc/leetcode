class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int i, int j) {
        if (i > j) {
            return null;
        }
        int pos = i;
        while (pos < preorder.length && preorder[pos] <= preorder[i]) {
            pos++;
        }
        TreeNode root = new TreeNode(preorder[i]);
        root.left = bstFromPreorder(preorder, i + 1, pos - 1);
        root.right = bstFromPreorder(preorder, pos, j);
        return root;
    }
}
