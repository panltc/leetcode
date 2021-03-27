class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 因为nums1的空间足够大，所以倒叙比较两个数组，并从尾部插入较大值
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // 遍历两个数组，进行大小比较
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        // 如果nums1遍历完了，而nums2没有遍历完，直接将所有的元素插入到nums1中
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
