class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    // visited数组用来记录当前递归栈中，哪个元素被访问了
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return res;
        }
        visited = new boolean[len];
        dfs(nums, new ArrayList<>(), visited);

        return res;
    }
    
    private void dfs(int[] nums, List<Integer> list, boolean[] visited) {
        // 如果list的元素个数足够了，就将其加入到res结果集中（list只是一个引用，所以需要复制一份新的list加入res）
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            
            return;
        }
        // 每次递归都遍历所有的元素，通过visisted数组来判断是否访问过该元素
        for (int i = 0; i < nums.length; i++) {
            /* 如果没有访问过当前元素，说明可以将其加入list中
             * 先将其置为true，代表访问了，然后加入list，进行下一层递归（每次递归都相当于固定了一个位置）
             * dfs返回只有一种可能，就是当前list已经满了，回退一个固定的元素，并将visited置为false
             */
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
