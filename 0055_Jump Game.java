class Solution {
    public boolean canJump(int[] nums) {
        for (int i = 0, max = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(i + nums[i], max);
        }
        return true;
    }
}
