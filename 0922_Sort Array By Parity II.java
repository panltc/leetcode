class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int i = 0;
        int j = N - 1;      
        while (i < N) {
            if (A[i] % 2 != 0) {
                swap(A, i, j);
                j -= 2;
            } else {
                i += 2;
            }
        }
        return A;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
