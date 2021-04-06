class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, targetSum, new ArrayList<Integer>());

        return res;
    }


    private void dfs(TreeNode root, int targetSum, List<Integer> list) {
        // 先将该结点加入list中，并且sum减去该结点的值（每次递归先处理当前结点）
        list.add(root.val);
        targetSum -= root.val;
        // 如果该结点是叶结点，并且当且sum的值为0，说明找到了一条路径，将其加入结果集
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<Integer>(list));
            // 一条路径确定后，需要删除加入的这个叶结点，防止污染别的路径
            list.remove(list.size() - 1);

            return;
        }
        // 如果当前递归函数没有返回，说明当前结点不是空结点，也不是符合条件的叶结点。假设该结点为路径的一部分，深度遍历左子树和右子树
        if (root.left != null) {
            dfs(root.left, targetSum, list);
        }
        if (root.right != null) {
            dfs(root.right, targetSum, list);
        }
        // 回溯，将本次递归添加的该结点移除
        list.remove(list.size() - 1);
    }
}
