class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        // 先对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < len - 2 && nums[i] <= 0; i++) {
            // 如果前三个元素相加大于0，那么后续必不存在相加为0的三元组，直接退出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            // 如果第一个元素和倒数两个元素相加小于0，则直接跳过
            if (nums[i] + nums[len - 2] + nums[len - 1] < 0) {
                continue;
            }
            // 跳过重复的i元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // j从i的下一个位置开始往后遍历
            int j = i + 1;
            // k从最后一个位置开始往前遍历
            int k = len - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 跳过重复的j元素
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    // 跳过重复的k元素
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    // 完成了跳过操作后，j和k会停留在最后一个重复元素上，所以还需要再跳过一次
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}
