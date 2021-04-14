class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        /* 动态规划方程：dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
         * dp[i][j]：到达下标为i，j的网格的路径总数
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 在第0行网格或第0列网格的时候，因为只能走一个方向，所以只有一条路径能到达这些网格
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
