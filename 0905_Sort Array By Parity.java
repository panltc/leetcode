class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        int k = 0;
        while (k <= j) {
            if (A[k] % 2 == 0) {
                swap(A, i++, k++);
            } else {
                swap(A, k, j--);
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
