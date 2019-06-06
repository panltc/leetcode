class Solution {
    public int heightChecker(int[] heights) {
        int N = heights.length;
        int[] tmp = Arrays.copyOf(heights, N);
        Arrays.sort(tmp);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (tmp[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
