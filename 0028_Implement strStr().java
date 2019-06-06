class Solution {
    public int[] getNext(String needle) {
        int N = needle.length();
        int[] next = new int[N];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < N - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
    public int strStr(String haystack, String needle) {
        int H = haystack.length();
        int N = needle.length();
        if (N == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < H && j < N) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == N ? i - j : -1;
    }
}
