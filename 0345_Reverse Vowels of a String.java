class Solution {
    public String reverseVowels(String s) {
        char[] ca = s.toCharArray();
        int i = 0;
        int j = ca.length - 1;
        while (i < j) {
            if (isVowel(ca[i]) && isVowel(ca[j])) {
                char tmp = ca[i];
                ca[i++] = ca[j];
                ca[j--] = tmp;
            } else if (isVowel(ca[i])) {
                j--;
            } else if (isVowel(ca[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(ca);
    }
    
    private boolean isVowel(char c) {
        if (c == 'A' || c == 'a' ||
            c == 'E' || c == 'e' ||
            c == 'I' || c == 'i' ||
            c == 'O' || c == 'o' ||
            c == 'U' || c == 'u') {
            return true;
        }
        return false;
    }
}
