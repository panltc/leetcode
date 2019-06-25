class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
