class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int data = Math.abs(num);
        while (data > 0) {
            sb.append(data % 7);
            data /= 7;
        }
        if (num < 0) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
