class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;

        /* 倒序开始查找，要找到第一个非递减的数，这个数需要和递减序列中的最小数进行交换
         * 随后将递减序列排列成递增序列
         */
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        int j = len - 1;
        if (i >= 0) {
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len - 1);
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
