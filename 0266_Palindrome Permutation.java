class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] cnts = new int[128];
        int odd = 0;
        for (char c : s.toCharArray()) {
            cnts[c]++;
            odd += cnts[c] % 2 == 0 ? -1 : 1;
        }
        return odd <= 1;
    }
}
