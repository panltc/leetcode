class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, targetSum, new ArrayList<Integer>());

        return res;
    }


    private void dfs(TreeNode root, int sum, List<Integer> list) {
        // 如果为空结点，直接返回
        if (root == null) {
            return;
        }

        // 先将该结点加入list中，并且sum减去该结点的值（试错）
        list.add(root.val);
        sum -= root.val;
        // 如果该结点是叶结点，并且当且sum的值为0，说明找到了一条路径，将其加入结果集
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<Integer>(list));
            // 一条路径确定后，需要删除加入的这个叶结点，不污染下一条路径
            list.remove(list.size() - 1);

            return;
        }
        // 如果当前递归函数没有返回，说明当前结点不是空结点，也不是符合条件的叶结点，那么假设该结点为路径的一部分，深度遍历左子树和右子树
        dfs(root.left, sum, list);
        dfs(root.right, sum, list);
        // 深度遍历左右子树后，需要回溯将当前结点移除（表示从这个结点开始的路径已经确定）
        list.remove(list.size() - 1);
    }
}
