class Solution {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (isVowel(cs[i]) && isVowel(cs[j])) {
                char tmp = cs[i];
                cs[i++] = cs[j];
                cs[j--] = tmp;
            } else if (isVowel(cs[i])) {
                j--;
            } else if (isVowel(cs[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(cs);
    }
    
    private boolean isVowel(char c) {
        if (c == 'A' || c == 'a' || 
            c == 'E' || c == 'e' || 
            c == 'I' || c == 'i' || 
            c == 'O' || c == 'o' || 
            c == 'U' || c == 'u')  {
            return true;
        }
        return false;
    }
}
