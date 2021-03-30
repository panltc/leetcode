class Solution {
    public int majorityElement(int[] nums) {
        // 投票法，默认一个元素为多数元素，cnt为票数
        int res = 0;
        int cnt = 0;

        for (int num : nums) {
            // 如果num等于当前默认多数元素，票数cnt加一
            if (num == res) {
                cnt++;
            } else {
                // num和当前默认多数元素不相同时，如果票数等于0，说明在已经遍历的元素中，默认的元素不是正确结果，更换为当前num，并将票数置为1
                if (cnt == 0) {
                    res = num;
                    cnt = 1;
                } else {
                    // 票数不为0的时候就减一
                    cnt--;
                }
            }
        }

        return res;
    }
}
