class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int cnt = 1;
        int cur = 0;
        for (char c : S.toCharArray()) {
            int width = widths[c - 'a'];
            if (cur + width > 100) {
                cnt++;
                cur = width;
            } else {
                cur += width;
            }
        }
        return new int[] {cnt, cur};
    }
}
