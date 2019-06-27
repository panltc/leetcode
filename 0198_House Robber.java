class Solution {
    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int num : nums) {
            int tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
