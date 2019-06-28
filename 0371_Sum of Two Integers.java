// Approach 1: iterative
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a ^= b;
            b = tmp;
        }
        return a;
    }
}

// Approach 2: recursive
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
