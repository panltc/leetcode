class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        int i = 0;
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        int MAX_QUOTIENT = Integer.MAX_VALUE / 10;
        int MAX_REMAINDER = Integer.MAX_VALUE % 10;
        int res = 0;
        while (i < len && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            int data = str.charAt(i++) - '0';
            if (res > MAX_QUOTIENT || (res == MAX_QUOTIENT && data > MAX_REMAINDER)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + data;
        }
        return res * sign;
    }
}
