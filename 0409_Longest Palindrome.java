class Solution {
    public int longestPalindrome(String s) {
        int[] cnts = new int[52];
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                cnts[c - 'A']++;
            } else {
                cnts[c - 'a' + 26]++;
            }
        }
        int res = 0;
        boolean odd = false;
        for (int cnt : cnts) {
            if (cnt % 2 != 0) {
                res += cnt - 1;
                odd = true;
            } else {
                res += cnt;
            }
        }
        return odd ? res + 1 : res;
    }
}
