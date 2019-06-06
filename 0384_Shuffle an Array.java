class Solution {
    private int[] nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int N = nums.length;
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int j = (int)(Math.random() * (i + 1));
            res[i] = res[j];
            res[j] = nums[i];
        }
        return res;
    }
}
