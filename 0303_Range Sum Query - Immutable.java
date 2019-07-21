class NumArray {
    private int[] nums;
    private int[] sums;

    public NumArray(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return;
        }
        this.nums = nums;
        sums = new int[N];
        sums[0] = nums[0];
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + nums[i];
    }
}
