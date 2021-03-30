class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 将矩阵看作是层次结构，定位每一层的四个边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        // 模拟每一层的遍历顺序，将其加入结果集中，每层遍历结束，需要往内部推进一层
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            for (int j = top; j < bottom; j++) {
                res.add(matrix[j][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int j = bottom; j > top; j--) {
                res.add(matrix[j][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        /*
         * 如果行或列是奇数，那么循环结束后，上下或者左右两个边界会重合
         * 如果四个边界全部重合，那么只需添加最后一个元素
         * 如果左右边界重合，说明还有中间一列需要添加
         * 如果上下边界重合，说明还有中间一行需要添加
         * 如果行或列是偶数，那么循环结束后，上下或者左右两个边界会异位，不用考虑
         */
        if (left == right && top == bottom) {
            res.add(matrix[left][top]);
        } else if (left == right) {
            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][left]);
            }
        } else if (top == bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
        }
        
        return res;
    }
}
