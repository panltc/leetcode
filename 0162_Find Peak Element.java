class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        // 如果nums[mid] < nums[mid + 1]，假设nums[mid + 1] > nums[mid + 1]，那mid + 1就是峰值位置，若不是，则继续后推，因为nums[n]为负无穷，所以mid + 1 ~ n必然存在峰值
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
