class Solution {
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int low = 0;
        int high = N - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        res[1] = high - 1;
        return res;
    }
}
