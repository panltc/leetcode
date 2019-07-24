class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] max1s = new int[N];
        int[] max2s = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max1s[i] = Math.max(grid[i][j], max1s[i]);
                max2s[j] = Math.max(grid[i][j], max2s[j]);
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += Math.min(max1s[i], max2s[j]) - grid[i][j];
            }
        }
        return res;
    }
}
