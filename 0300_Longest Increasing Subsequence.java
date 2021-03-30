class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
         * 动态规划方程：f(n) = num < f(n - 1) ? f(n - 1) : f(n - 1) + 1
         * f(n)：n + 1长度的最长递增子序列的最小尾部元素
         */
        int[] ends = new int[nums.length];

        for (int num : nums) {
            // ends数组是严格递增的，可以使用二分查找法查找当前num在ends数组中的位置，res就是右边界
            int low = 0;
            int high = res;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (ends[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            /* 遍历每个元素都会更新ends数组
             * 如果num小于ends某个元素，num就会替换这个元素，意即：原来的递增子序列以新元素作为结尾
             * 如果num大于ends的所有元素，num就会接在ends后面，意即：原来的最长子序列后面接了一个更大的元素，生成了一个更长的递增子序列
             */
            ends[low] = num;
            // 如果low停留在了res上，说明当前num能接在当前最长的递增子序列后面，最大长度res要加一
            if (low == res) {
                res++;
            }
        }

        return res;
    }
}
