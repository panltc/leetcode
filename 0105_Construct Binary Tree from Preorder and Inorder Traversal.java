class Solution {
    // map存储中序序列中各结点的值和对应的位置
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private TreeNode buildTree(int[] preorder, int preorderLeft, int preorderRight, int[] inorder, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        // preorderLeft位置的元素就是本次递归要创建的根结点
        int preorderRoot = preorderLeft;
        // 在map中查找根结点在中序数组中的位置
        int inorderRoot = map.get(preorder[preorderRoot]);
        // 中序序列中，根节点位置和左边界之间的元素个数就是左子树包含的结点数
        int cnt = inorderRoot - inorderLeft;

        // 创建一个根结点，值就是前序数组的第一个元素
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        /*
         * 左子树的范围是：前序数组从左边界右一个元素开始，总共有cnt个元素。中序数组从左边界开始，到根结点左一个元素为止
         * 右子树的范围是：前序数组从左子树范围右一个元素开始，到右边界为止。中序数组从根结点右一个元素开始，到右边界为止
         */
        root.left = buildTree(preorder, preorderLeft + 1, preorderLeft + cnt, inorder, inorderLeft, inorderRoot - 1);
        root.right = buildTree(preorder, preorderLeft + cnt + 1, preorderRight, inorder, inorderRoot + 1, inorderRight);

        return root;
    }
}
