class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int ipre, int jpre, int[] inorder, int iin, int jin) {
        if (ipre > jpre || iin > jin) {
            return null;
        }
        int pos = 0;
        for (int k = iin; k <= jin; k++) {
            if (inorder[k] == preorder[ipre]) {
                pos = k;
            }
        }
        int cnt = pos - iin;
        TreeNode root = new TreeNode(preorder[ipre]);
        root.left = buildTree(preorder, ipre + 1, ipre + cnt, inorder, iin, pos - 1);
        root.right = buildTree(preorder, ipre + cnt + 1, jpre, inorder, pos + 1, jin);
        return root;
    }
}
