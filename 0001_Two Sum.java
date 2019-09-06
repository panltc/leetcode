class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int data = target - nums[i];
            if (map.containsKey(data)) {
                return new int[] {map.get(data), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
