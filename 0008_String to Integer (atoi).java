class Solution {
    public int myAtoi(String str) {
        int N = str.length();
        int i = 0;
        while (i < N && str.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < N && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        int MAX_QUOTIENT = Integer.MAX_VALUE / 10;
        int MAX_REMAINDER = Integer.MAX_VALUE % 10;
        int res = 0;
        while (i < N && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            int cur = str.charAt(i++) - '0';
            if (res > MAX_QUOTIENT || (res == MAX_QUOTIENT && cur > MAX_REMAINDER)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + cur;
        }
        return res * sign;
    }
}
