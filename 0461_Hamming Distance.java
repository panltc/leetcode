// solution 1
class Solution {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int res = 0;
        while (i != 0) {
            res++;
            i &= i - 1;
        }
        return res;
    }
}

// solution 2
class Solution {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int res = 0;
        while (i != 0) {
            res += i & 1;
            i >>>= 1;
        }
        return res;
    }
}
