class Solution {
    public char findTheDifference(String s, String t) {
        int N = s.length();
        char res = t.charAt(N);
        for (int i = 0; i < N; i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        return res;
    }
}
