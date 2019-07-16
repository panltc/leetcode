class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        int cur = 1;
        int max = 1;
        for (int i = 1; i < N; i++) {
            cur = nums[i] > nums[i - 1] ? cur + 1 : 1;
            max = Math.max(cur, max);
        }
        return max;
    }
}
