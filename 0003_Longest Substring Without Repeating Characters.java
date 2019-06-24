class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            while (!set.add(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            j++;
            res = Math.max(j - i, res);
        }
        return res;
    }
}
