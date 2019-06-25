class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < N - 2; i++) {
            int j = i + 1;
            int k = N - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }
}
