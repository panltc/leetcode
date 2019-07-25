class Solution {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        if (N < 3) {
            return false;
        }
        int i = 0;
        while (i < N - 1 && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == N - 1) {
            return false;
        }
        while (i < N - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == N - 1;
    }
}
