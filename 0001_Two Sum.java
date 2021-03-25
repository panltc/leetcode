class Solution {
    public int[] twoSum(int[] nums, int target) {
        // map的key为元素，value为元素的下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // data为目标和当前元素的差值
            int data = target - nums[i];
            // 如果map的key中存在该差值，直接将该差值的下标和当前下标返回即可
            if (map.containsKey(data)) {
                return new int[] {map.get(data), i};
            }
            // 将每一个元素和其下标加入map
            map.put(nums[i], i);
        }

        return null;
    }
}
