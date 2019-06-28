// Approach 1
class Solution {
    public int hammingDistance(int x, int y) {
        int data = x ^ y;
        int res = 0;
        while (data != 0) {
            res++;
            data &= data - 1;
        }
        return res;
    }
}

// Approach 2
class Solution {
    public int hammingDistance(int x, int y) {
        int data = x ^ y;
        int res = 0;
        while (data != 0) {
            res += data & 1;
            data >>>= 1;
        }
        return res;
    }
}
