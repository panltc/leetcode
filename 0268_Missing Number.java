class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        int res = N;
        for (int i = 0; i < N; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}
