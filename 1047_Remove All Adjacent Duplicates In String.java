class Solution {
    public String removeDuplicates(String S) {
        char[] data = new char[S.length()];
        int i = 0;
        for (char c : S.toCharArray()) {
            if (i == 0 || c != data[i - 1]) {
                data[i++] = c;
            } else {
                i--;
            }
        }
        return String.valueOf(data, 0, i);
    }
}
