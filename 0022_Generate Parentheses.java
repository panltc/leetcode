class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        backtrack(n, 0, 0, "", res);
        return res;
    }
    
    private void backtrack(int n, int i, int j, String cur, List<String> res) {
        if (j == n) {
            res.add(cur);
            return;
        }
        if (i < n) {
            backtrack(n, i + 1, j, cur + "(", res);
        }
        if (j < i) {
            backtrack(n, i, j + 1, cur + ")", res);
        }
    }
}
