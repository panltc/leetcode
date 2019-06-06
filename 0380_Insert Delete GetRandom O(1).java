class RandomizedSet {
    private Map<Integer, Integer> map1 = new HashMap<>();
    private Map<Integer, Integer> map2 = new HashMap<>();
    private int size = 0;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map1.containsKey(val)) {
            map1.put(val, size);
            map2.put(size++, val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map1.containsKey(val)) {
            int cur = map1.get(val);
            int last = --size;
            int key = map2.get(last);
            map1.put(key, cur);
            map2.put(cur, key);
            map1.remove(val);
            map2.remove(last);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return map2.get((int)(Math.random() * size));
    }
}
