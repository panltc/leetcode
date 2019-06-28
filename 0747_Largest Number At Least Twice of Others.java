class Solution {
    public int dominantIndex(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        int sm = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                sm = max;
                max = nums[i];
                res = i;
            } else if (nums[i] > sm) {
                sm = nums[i];
            }
        }
        return max < sm * 2 ? -1 : res;
    }
}
