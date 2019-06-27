class TwoSum {
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            int cur = value - key;
            if (cur == key && map.get(key) > 1) {
                return true;
            }
            if (cur != key && map.containsKey(cur)) {
                return true;
            }
        }
        return false;
    }
}
