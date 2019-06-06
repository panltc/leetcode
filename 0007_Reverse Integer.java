class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int cur = res * 10 + x % 10;
            if (cur / 10 != res) {
                return 0;
            }
            res = cur;
            x /= 10;
        }
        return res;
    }
}
