class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        int tmp = n;
        while (n != 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return tmp < 0 ? 1 / res : res;
    }
}
