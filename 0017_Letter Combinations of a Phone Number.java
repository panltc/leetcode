class Solution {
    private List<String> res = new ArrayList<>();
    private String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        dfs(digits, 0, "");
        return res;
    }
    
    private void dfs(String digits, int i, String data) {
        if (i == digits.length()) {
            res.add(data);
            return;
        }
        String str = strs[digits.charAt(i) - '0'];
        for (char c : str.toCharArray()) {
            dfs(digits, i + 1, data + c);
        }
    }
}
