class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[len - 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int pos = low;
        low = 0;
        high = len - 1;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = (mid1 + pos) % len;
            if (nums[mid2] == target) {
                return mid2;
            }
            if (nums[mid2] < target) {
                low = mid1 + 1;
            } else {
                high = mid1 - 1;
            }
        }
        return -1;
    }
}
