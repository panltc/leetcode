class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int cur = Math.abs(num);
        while (cur > 0) {
            sb.append(cur % 7);
            cur /= 7;
        }
        if (num < 0) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
