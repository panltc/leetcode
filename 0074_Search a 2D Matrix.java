// Approach 1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        if (M == 0) {
            return false;
        }
        int N = matrix[0].length;
        int[] data = new int[M * N];
        int k = 0;
        for (int i = 0; i < M; i++) {
            for (int j= 0; j < N; j++) {
                data[k++] = matrix[i][j];
            }
        }
        int low = 0;
        int high = M * N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == target) {
                return true;
            }
            if (data[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}

// Approach 2
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
