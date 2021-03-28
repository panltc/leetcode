// Approach 1: bfs
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                /*
                 * 遍历二维数组，如果遍历到的是陆地，即为'1'，则调用bfs函数，往四周扩散，将所有的'1'都变为'2'
                 * 因为调用一次bfs函数就能改变一个岛屿的全部陆地，相当于确定了一个岛屿，所以res加一
                 */
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        // dirs代表往四个方向移动的距离，例如{1, 0}表示往x轴正方向移动1格，y轴位置不变
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        // 先把该陆地变为'2'
        grid[i][j] = '2';
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                // x和y是往四周扩散后的新位置
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                // x和y不能超过地图的边界，而且只能往陆地扩散
                if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] != '1') {
                    continue;
                }
                // 将新位置变为'2'
                grid[x][y] = '2';
                queue.offer(new int[] {x, y});
            }
        }
    }
}

// Approach 2: dfs
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                /*
                 * 遍历二维数组，如果遍历到的是陆地，即为'1'，则调用dfs函数，往四周扩散，将所有的'1'都变为'2'
                 * 因为调用一次dfs函数就能改变一个岛屿的全部陆地，相当于确定了一个岛屿，所以res加一
                 */
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        // 递归调用dfs函数，往四周扩散
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
