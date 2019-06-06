class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (int key : map.keySet()) {
            pq.offer(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
