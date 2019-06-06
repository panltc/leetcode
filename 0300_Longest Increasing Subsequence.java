class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] mins = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int begin = 0;
            int end = res;
            while (begin < end) {
                int mid = begin + (end - begin) / 2;
                if (mins[mid] < num) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
            mins[begin] = num;
            if (begin == res) {
                res++;
            }
        }
        return res;
    }
}
