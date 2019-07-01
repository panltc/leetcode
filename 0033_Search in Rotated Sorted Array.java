class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;
        int low = 0;
        int high = N - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int pos = low;
        low = 0;
        high = N -1;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = (mid1 + pos) % N;
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
