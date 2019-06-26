class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        if (M == 0) {
            return false;
        }
        int N = matrix[0].length;
        int i = 0;
        int j = N - 1;
        while (i < M && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
