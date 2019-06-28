class Solution {
    public int heightChecker(int[] heights) {
        int N = heights.length;
        int[] data = Arrays.copyOf(heights, N);
        Arrays.sort(data);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (data[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
