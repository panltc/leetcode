// solution 1
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
        int j = 0;
        int k = N - 1;
        while (j < k) {
            for (int i = 0; i < N; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
            }
            j++;
            k--;
        }
    }
}

// solution 2
class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int tr = 0;
        int tc = 0;
        int dr = N - 1;
        int dc = N - 1;
        while (tr < dr) {
            rotateEdge(matrix, tr++, tc++, dr--, dc--);
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
