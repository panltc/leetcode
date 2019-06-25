class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (!set.add(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            res = Math.max(j - i + 1, res);
        }
        return res;
    }
}
