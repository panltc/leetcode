class Solution {
    private List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        dfs(n, 0, 0, "");
        return res;
    }
    
    private void dfs(int n, int i, int j, String data) {
        if (j == n) {
            res.add(data);
            return;
        }
        if (i < n) {
            dfs(n, i + 1, j, data + '(');
        }
        if (j < i) {
            dfs(n, i, j + 1, data + ')');
        }
    }
}
