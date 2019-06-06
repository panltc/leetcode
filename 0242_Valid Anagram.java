// solution 1
class Solution {
    public boolean isAnagram(String s, String t) {
        int S = s.length();
        int T = t.length();
        if (S != T) {
            return false;
        }
        int[] cnts = new int[26];
        for (int i = 0; i < S; i++) {
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

// solution 2
class Solution {
    public boolean isAnagram(String s, String t) {
        int S = s.length();
        int T = s.length();
        if (S != T) {
            return false;
        }
        int[] cnts = new int[26];
        for (int i = 0; i < S; i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < T; i++) {
            if (cnts[t.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }
}
