// solution 1
class Solution {
    public boolean isPowerOfThree(int n) {
        return (n > 0) && (1162261467 % n == 0);
    }
}

// solution 2
class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
