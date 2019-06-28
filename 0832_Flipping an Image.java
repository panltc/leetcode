class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1; j <= k; j++, k--) {
                int tmp = 1 - A[i][j];
                A[i][j] = 1 - A[i][k];
                A[i][k] = tmp;
            }
        }
        return A;
    }
}
