// Approach 1
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
            cnts[t.charAt(i) - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}

// Approach 2
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (cnts[c - 'a'] == 0) {
                return false;
            }
            cnts[c - 'a']--;
        }
        return true;
    }
}
