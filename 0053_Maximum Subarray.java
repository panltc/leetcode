class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        // curr代表已有最大子序和
        int curr = 0;
        
        /*
         * 动态规划方程：f(n) = max(f(n − 1) + nums[i], nums[i])
         * f(n)：以下标n结尾的子序列的最大和
         */
        for (int num : nums) {
            // 若已有最大子序和加num后大于num，则num应该加入子序列中，否则，以当前元素重新作为子序列的开始
            curr = Math.max(curr + num, num);
            // 对每个元素进行操作后都会得到一个以当前元素结尾或开始的子序列的最大和，与已有的最大子序和进行比较，取最大值
            res = Math.max(res, curr);
        }

        return res;
    }
}
