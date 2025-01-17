class Solution {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        if (cnt == 0) {
            return 0;
        }
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x == M || y < 0 || y == N || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    cnt--;
                    queue.offer(new int[] {x, y});
                }
            }
            res++;
        }
        return cnt == 0 ? res - 1 : -1;
    }
}
