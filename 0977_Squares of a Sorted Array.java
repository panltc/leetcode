class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        for (int i = 0, j = N - 1, k = N - 1; k >= 0; k--) {
            res[k] = Math.abs(A[i]) < Math.abs(A[j]) ? A[j] * A[j--] : A[i] * A[i++];
        }
        return res;
    }
}
