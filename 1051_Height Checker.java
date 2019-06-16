class Solution {
    public int heightChecker(int[] heights) {
        int N = heights.length;
        int[] arr = Arrays.copyOf(heights, N);
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
