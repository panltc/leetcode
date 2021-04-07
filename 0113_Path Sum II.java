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
        // 若为空结点，返回
        if (root == null) {
            return;
        }
        // 如果该结点是叶结点，并且当前targetSum减去当前结点的值后为0，说明找到了一条路径，先将该结点加入list，并将其加入结果集，最后仍需要删除新加入的结点
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            list.add(root.val);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);

            return;
        }
        list.add(root.val);
        // 假设该结点为路径的一部分，targetSum要减去本层结点的值（每层处理每层targetSum的值），并深度遍历左子树和右子树
        dfs(root.left, targetSum - root.val, list);
        dfs(root.right, targetSum - root.val, list);
        // 回溯，将本次递归添加的该结点移除
        list.remove(list.size() - 1);
    }
}
