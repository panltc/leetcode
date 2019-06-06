class Solution {
    public int pivotIndex(int[] nums) {
        int sum1 = 0;
        for (int num : nums) {
            sum1 += num;
        }
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum2 * 2 + nums[i] == sum1) {
                return i;
            }
            sum2 += nums[i];
        }
        return -1;
    }
}
