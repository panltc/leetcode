class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        for (int i = 0, j = N - 1, k = N - 1; k >= 0; k--) {
            if (Math.abs(A[i]) < Math.abs(A[j])) {
                res[k] = A[j] * A[j];
                j--;
            } else {
                res[k] = A[i] * A[i];
                i++;
            }
        }
        return res;
    }
}
