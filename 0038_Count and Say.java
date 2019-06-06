class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = generate(res);
        }
        return res;
    }
    
    private String generate(String s) {
        StringBuilder sb = new StringBuilder();
        char cur = s.charAt(0);
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c != cur) {
                sb.append(cnt);
                sb.append(cur);
                cur = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        sb.append(cnt);
        sb.append(cur);
        return sb.toString();
    }
}
