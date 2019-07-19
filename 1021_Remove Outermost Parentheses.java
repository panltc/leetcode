class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (cnt > 0) {
                    sb.append(c);
                }
                cnt++;
            } else {
                if (--cnt > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
