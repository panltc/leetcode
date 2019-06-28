class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (sb.length() % (K + 1) == K) {
                    sb.append('-');
                }
                sb.append(c >= 'a' && c <= 'z' ? (char)(c - 'a' + 'A') : c);
            }
        }
        return sb.reverse().toString();
    }
}
