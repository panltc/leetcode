class Solution {
    public List<String> letterCombinations(String digits) {
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(digits, strs, 0, "", res);
        return res;
    }
    
    private void backtrack(String digits, String[] strs, int i, String cur, List<String> res) {
        if (i == digits.length()) {
            res.add(cur);
            return;
        }
        String str = strs[digits.charAt(i) - '0'];
        for (char c : str.toCharArray()) {
            backtrack(digits, strs, i + 1, cur + c, res);
        }
    }
}
