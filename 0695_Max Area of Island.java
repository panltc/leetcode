// Approach 1: bfs
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(bfs(grid, i, j), res);
                }
            }
        }
        return res;
    }
    
    private int bfs(int[][] grid, int i, int j) {
        int cnt = 1;
        grid[i][j] = 2;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] != 1) {
                    continue;
                }
                grid[x][y] = 2;
                cnt++;
                queue.offer(new int[] {x, y});
            }
        }
        return cnt;
    }
}

// Approach 2: dfs
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1;
    }
}
