// Approach 1: Iterative
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}

// Approach 2: Recursive
class Solution {
    public int trailingZeroes(int n) {
        return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
