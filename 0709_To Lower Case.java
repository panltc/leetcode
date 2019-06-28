class Solution {
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'A' && cs[i] <= 'Z') {
                cs[i] += 'a' - 'A';
            }
        }
        return String.valueOf(cs);
    }
}
