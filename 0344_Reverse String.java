// Approach 1: iterative
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}

// Approach 2: recursive
class Solution {
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }
    
    private void reverseString(char[] s, int i, int j) {
        if (i > j) {
            return;
        }
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        reverseString(s, i + 1, j - 1);
    }
}
