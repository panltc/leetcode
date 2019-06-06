class Solution {
    public int firstUniqChar(String s) {
        int N = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < N; i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < N; i++) {
            if (cnts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
