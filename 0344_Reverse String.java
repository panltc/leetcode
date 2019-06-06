// solution 1 (iterative)
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}

// solution 2 (recursive)
class Solution {
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }
    
    private void reverseString(char[] s, int i, int j) {
        if (i >= j) {
            return;
        }
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        reverseString(s, i + 1, j - 1);
    }
}
