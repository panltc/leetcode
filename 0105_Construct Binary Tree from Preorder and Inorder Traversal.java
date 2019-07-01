class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int beginpre, int endpre, int[] inorder, int beginin, int endin) {
        if (beginpre > endpre || beginin > endin) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[beginpre]);
        int pos = 0;
        while (inorder[pos] != preorder[beginpre]) {
            pos++;
        }
        int cnt = i - beginin;
        root.left = buildTree(preorder, beginpre + 1, beginpre + cnt, inorder, beginin, pos - 1);
        root.right = buildTree(preorder, beginpre + cnt + 1, endpre, inorder, pos + 1, endin);
        return root;
    }
}
