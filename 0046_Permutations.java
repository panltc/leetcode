class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (N == 0) {
            return res;
        }
        boolean[] visited = new boolean[N];
        backtrack(nums, visited, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] nums, boolean[] visited, int i, List<Integer> list, List<List<Integer>> res) {
        int N = nums.length;
        if (i == N) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < N; j++) {
            if (!visited[j]) {
                list.add(nums[j]);
                visited[j] = true;
                backtrack(nums, visited, i + 1, list, res);
                visited[j] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
