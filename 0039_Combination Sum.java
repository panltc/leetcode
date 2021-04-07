class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        dfs(candidates, target, 0, new ArrayList<Integer>());

        return res;
    }

    private void dfs(int[] candidates, int target, int i, List<Integer> list) {
        // 当前target为0，说明找到了一种组合，将其加入结果集
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));

            return ;
        }
        if (target < 0) {
            return;
        }
        // 固定一个元素后，就需要在当前元素及其后面元素中进行遍历，否则会产生重复
        for (int j = i; j < candidates.length; j++) {
            list.add(candidates[j]);
            // 事先在本层递归中处理好target的值，但不能写成target -= candidates[j]，因为这会在循环中不断改变target的值
            dfs(candidates, target - candidates[j], j, list);
            list.remove(list.size() - 1);
        }
    }
}
