// Approach 1
class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int j = 0, k = N - 1; j < k; j++, k--) {
            for (int i = 0; i < N; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
            }
        }
    }
}

// Approach 2
class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int tr = 0, tc = 0, dr = N - 1, dc = N - 1; tr < dr; tr++, tc++, dr--, dc--) {
            rotateEdge(matrix, tr, tc, dr, dc);
        }
    }
    
    private void rotateEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
        for (int i = 0; i < dc - tc; i++) {
            int tmp = matrix[tr][tc + i];
            matrix[tr][tc + i] = matrix[dr - i][tc];
            matrix[dr - i][tc] = matrix[dr][dc - i];
            matrix[dr][dc - i] = matrix[tr + i][dc];
            matrix[tr + i][dc] = tmp;
        }
    }
}
