class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;

        // 二分查找法逼近旋转点
        while (low < high) {
            int mid = low + (high - low) / 2;
            /*
             * 如果mid位置的值小于尾值，说明mid正好在旋转点或者在旋转点右侧，high移动到mid位置
             * 如果mid位置的值大于尾值，说明mid在旋转点左侧，low移动到mid后一个位置
             * low最后会落在旋转点位置
             */
            if (nums[mid] < nums[len - 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // offset是旋转偏移量
        int offset = low;
        low = 0;
        high = len - 1;
        
        while (low <= high) {
            // mid1是物理中间点
            int mid1 = low + (high - low) / 2;
            // 将旋转数组的每个元素偏移offset大小后，就成为了一个逻辑上的有序数组，mid2就是该有序数组的逻辑中间点
            int mid2 = (mid1 + offset) % len;
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
