class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            cur = Math.max(num, cur + num);
            max = Math.max(cur, max);
        }
        return max;
    }
}
