class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j, 0), res);
                }
            }
        }
        return res;
    }
    
    private int dfs(int[][] grid, int i, int j, int cnt) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        cnt++;
        cnt += dfs(grid, i - 1, j, 0) + dfs(grid, i + 1, j, 0) + dfs(grid, i, j - 1, 0) + dfs(grid, i, j + 1, 0);
        return cnt;
    }
}
