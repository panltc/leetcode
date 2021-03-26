class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        // 因为字符串的和可能超过了int的范围，所以不能从首位开始单纯累加数字，需要从末位开始对单独位的数字进行和运算。
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int sum = 0;

        // 两个字符串不一定等长，所以判断条件为或。同时，即使两个字符串都遍历完毕，若存在一个进位，仍需进行操作。
        while (i >= 0 || j >= 0 || sum != 0) {
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            // sum取模操作可以得出单独的个位
            sb.append(sum % 10);
            // 若sum > 10，则说明存在进位，除以10后变为1，代表进位，会累加到下次运算中。若sum < 10，则说明没有进位，除以10后变为0，不影响下次运算。
            sum /= 10;
        }

        // sb是从末位开始记录和的，输出的时候需要反转。
        return sb.reverse().toString();
    }
}
