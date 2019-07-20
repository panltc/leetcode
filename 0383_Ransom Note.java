class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnts = new int[26];
        for (char c : magazine.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--cnts[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
