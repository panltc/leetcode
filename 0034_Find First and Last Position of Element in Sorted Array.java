class Solution {
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int low = 0;
        int high = N - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                high = mid;
            }
        }
        int[] res = new int[] {-1, -1};
        if (high < 0 || nums[low] != target) {
            return res;
        }
        res[0] = low;
        high = N;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        res[1] = high - 1;
        return res;
    }
}
