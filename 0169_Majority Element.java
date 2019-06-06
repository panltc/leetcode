class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt != 0) {
                cnt += res == num ? 1 : -1;
            } else {
                res = num;
                cnt = 1;
            }
        }
        return res;
    }
}
