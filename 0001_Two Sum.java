class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = target - nums[i];
            if (map.containsKey(cur)) {
                return new int[] {map.get(cur), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
