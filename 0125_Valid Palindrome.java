class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            } else if (c >= 'A' && c <='Z') {
                sb.append((char)(c - 'A' + 'a'));
            }
        }
        for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
