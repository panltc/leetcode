class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                cnt = 1;
            } else {
                cnt += num == res ? 1 : -1;
            }
        }
        return res;
    }
}
