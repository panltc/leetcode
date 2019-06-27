class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                res = Math.min(j - i + 1, res);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
