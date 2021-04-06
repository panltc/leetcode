class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        if (M == 0) {
            return false;
        }

        int N = matrix[0].length;
        int i = 0;
        int j = N - 1;

        /*
         * 行内有序递增，下一行的元素大于上一行的元素（也就是右大于左，下大于上），所以一个位置可以往两个方向进行查找
         * 如果从左下和右上两个点开始遍历，则只能往一个方向进行查找(比该位置小的只能在左边，大的只能在下边)，缩小了查找范围
         */
        while (i < M && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            // 如果当前元素小于target，i增加
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
