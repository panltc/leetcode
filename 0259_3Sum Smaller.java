class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < N - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] >= target) {
                break;
            }
            int j = i + 1;
            int k = N - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
