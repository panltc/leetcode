class Solution {
    public String longestPalindrome(String s) {
        char[] manacher = new char[s.length() * 2 + 1];
        int N = manacher.length;
        for (int i = 0, j = 0; i < N; i++) {
            manacher[i] = i % 2 == 0 ? '#' : s.charAt(j++);
        }
        int[] p = new int[N];
        int res = 0;
        int max = 0;
        for (int i = 0, center = 0, next = 0; i < N; i++) {
            p[i] = next > i ? Math.min(p[center * 2 - i], next - i) : 1;
            while (i + p[i] < N && i - p[i] > -1) {
                if (manacher[i + p[i]] == manacher[i - p[i]]) {
                    p[i]++;
                } else {
                    break;
                }
            }
            if (i + p[i] > next) {
                next = i + p[i];
                center = i;
            }
            if (p[i] > max) {
                max = p[i];
                res = i;
            }
        }
        return s.substring((res - max + 1) / 2, (res + max) / 2);
    }
}
