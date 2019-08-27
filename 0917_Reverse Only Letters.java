class Solution {
    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (Character.isLetter(cs[i]) && Character.isLetter(cs[j])) {
                char tmp = cs[i];
                cs[i++] = cs[j];
                cs[j--] = tmp;
            } else if (Character.isLetter(cs[i])) {
                j--;
            } else if (Character.isLetter(cs[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(cs);
    }
}
