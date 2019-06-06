class Solution {
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int begin = 0;
        int end = N - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        int[] res = new int[] {-1, -1};
        if (end < 0 || nums[end] != target) {
            return res;
        }
        res[0] = begin;
        end = N;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] <= target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        res[1] = begin - 1;
        return res;
    }
}
