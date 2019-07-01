class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] ends = new int[nums.length];
        for (int num : nums) {
            int low = 0;
            int high = res;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (ends[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            ends[low] = num;
            if (low == res) {
                res++;
            }
        }
        return res;
    }
}
