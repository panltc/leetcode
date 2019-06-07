class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || sum != 0) {
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            res = sum % 2 + res;
            sum /= 2;
        }
        return res;
    }
}
